import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Platform;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SpinnerPage;
import pages.ViewsPage;
import utils.PropertyReader;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestAppium {
    private AndroidDriver driver;
    private AppiumDriverLocalService service;
    private PropertyReader propertyReader;

    //Test Case
    @Test
    public void testServer() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToViews();

        ViewsPage viewsPage = new ViewsPage(driver);
        viewsPage.navigateToSpinner();

        SpinnerPage spinnerPage = new SpinnerPage(driver);

        Assert.assertTrue(spinnerPage.isColorFieldDisplayed(), "Field is not Displayed");
    }

    //Set Up Appium Service on time before all tests run
    @BeforeClass
    public void setUpAppiumService() {
        propertyReader = new PropertyReader("./src/main/resources/Environment.properties"); //Path of Environment.Properties;
        service = new AppiumServiceBuilder()
                .withIPAddress(propertyReader.getProperty("ipAddress")) // Set the address
                .usingPort(Integer.parseInt(propertyReader.getProperty("port")))// Set the port
                .withArgument(() -> "--use-drivers", propertyReader.getProperty("driver")) //To Run Appium with specific driver
                .build();
        service.start();
    }

    //Set up clean driver for each test
    @BeforeMethod
    public void setUpDriver() {
        UiAutomator2Options options = new UiAutomator2Options() //To add UiAutomator Capabilities (Options)
                .setDeviceName(propertyReader.getProperty("device")) //Running Device Name(e.g. like the name from Android Studio)
                .noReset() //To make appium not start with clean state (e.g. doesn't reinstall the app every run)
                .setPlatformName(Platform.ANDROID.name()) //Platform name
                .setPlatformVersion("15") //Platform version
                .setApp(System.getProperty("user.dir") + "/src/test/resources/" + propertyReader.getProperty("app")); //Path of the App (ApiDemos-debug.apk)

        try {
            driver = new AndroidDriver(
                    new URI("http://"
                            + propertyReader.getProperty("ipAddress") + ":" //Must be the same Address Appium is running on
                            + propertyReader.getProperty("port")).toURL(), options);//Must be the same port Appium is running on
        } catch (MalformedURLException | URISyntaxException e) {
           throw new RuntimeException(e);
        }
    }

    //Close the Running Driver after every test finishes
    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    //Close the Running Service after all tests finish
    @AfterClass
    public void tearDownAppiumService() {
        if (service != null) {
            service.stop();
        }
    }
}

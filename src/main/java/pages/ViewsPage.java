package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Actions;

public class ViewsPage {
    private AndroidDriver driver;

    private final By spinner_tab = AppiumBy.accessibilityId("Spinner");

    public ViewsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public ViewsPage navigateToSpinner() {
        Actions.scrollToText(driver, "Spinner");
        Actions.click(spinner_tab, driver);
        return this;
    }

}

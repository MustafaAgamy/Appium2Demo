package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Actions;
import utils.Finder;

public class SpinnerPage {
    private AndroidDriver driver;

    private final By colorField = AppiumBy.accessibilityId("Color:");

    public SpinnerPage(AndroidDriver driver) {
        this.driver = driver;
    }


    public boolean isColorFieldDisplayed() {
        return Actions.isDisplayed(colorField, driver);
    }
}

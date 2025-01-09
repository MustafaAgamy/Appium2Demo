package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import utils.Actions;


public class HomePage {
    private AndroidDriver driver;

    private final By preference_tab = AppiumBy.accessibilityId("Preference");
    private final By views_tab = AppiumBy.accessibilityId("Views");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public HomePage navigateToPreference() {
        Actions.click(preference_tab, driver);
        return this;
    }

    public HomePage navigateToViews() {
        Actions.click(views_tab, driver);
        return this;
    }


}

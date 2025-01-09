package utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;

public class Actions {

    /**
     * SendKeys to Element, Will try to wait for Element to Be Visible,
     * if it fails it will try to execute Javascript,
     * if it fails again it will ignore visibility and try one more time
     * @param locator the by locator used to find the element
     * @param driver the WebDriver instance
     */
    public static void type(final By locator, final WebDriver driver, String... keys) {
        try {
            Finder.elementVisibility(locator, driver).sendKeys(keys);
        } catch (NoSuchElementException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].value = arguments[1];",
                    Finder.elementVisibility(locator, driver));
        } catch (Exception e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].value = arguments[1];",
                    Finder.elementPresence(locator, driver));
        }
    }

    /**
     * Click on Element, Will try to wait for Element to Be Visible,
     * if it fails it will try to execute Javascript,
     * if it fails again it will ignore visibility and try one more time
     * @param locator the by locator used to find the element
     * @param driver the WebDriver instance
     */
    public static void click(final By locator, final WebDriver driver) {
        try {
            Finder.elementVisibility(locator, driver).click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",
                    Finder.elementVisibility(locator, driver));
        } catch (NoSuchElementException e) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();",
                    Finder.elementPresence(locator, driver));
        }
    }

    /**
     * Get Element Text, Will try to wait for Element to Be Visible,
     * if it fails it will try to execute Javascript,
     * if it fails again it will ignore visibility and try one more time
     * @param locator the by locator used to find the element
     * @param driver the WebDriver instance
     */
    public static String getText(final By locator, final WebDriver driver) {
        try {
          return  Finder.elementVisibility(locator, driver).getText();
        } catch (NoSuchElementException e) {
        return Finder.elementPresence(locator, driver).getText();
        }
    }

    /**
     * Get Element is Displayed
     * @param locator the by locator used to find the element
     * @param driver the WebDriver instance
     */
    public static boolean isDisplayed(final By locator, final WebDriver driver) {
            return  Finder.elementVisibility(locator, driver).isDisplayed();
    }

    /**
     * Scroll to Element, using UiScrollable,
     * @Docs_Link: <a href="https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable#scrollIntoView(androidx.test.uiautomator.UiObject)">...</a>
     * @param text the text to locate element by
     * @param driver  the WebDriver instance
     *
     */
    public static void scrollToText(final WebDriver driver, final String text) {
        Finder.elementPresence(AppiumBy.androidUIAutomator(String.format(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text)),
                driver);
    }

}

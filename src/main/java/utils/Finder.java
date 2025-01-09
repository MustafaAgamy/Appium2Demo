package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Finder {

    /**
     * Waits for the element to be present in the DOM.
     *
     * @param locator the by locator used to find the element
     * @param driver the WebDriver instance
     * @return instance of the WebElement
     */
    protected static WebElement elementPresence(final By locator, final WebDriver driver) {
        return wait(driver).until(driver1 -> driver.findElement(locator));
    }

    /**
     * Waits for the element to be present in the DOM and Visible on the screen.
     *
     * @param locator the by locator used to find the element
     * @param driver the WebDriver instance
     * @return instance of the WebElement
     */
    protected static WebElement elementVisibility(final By locator, final WebDriver driver) {
        return wait(driver).until(driver1 -> {
           WebElement webElement = driver.findElement(locator);
           return webElement.isDisplayed() ? webElement : null;
        });
    }

    /**
     * Private method to initiate the WebDriverWait Object.
     *
     * @param driver the WebDriver instance
     * @return instance of WebDriverWait Object
     */
    private static WebDriverWait wait(final WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}

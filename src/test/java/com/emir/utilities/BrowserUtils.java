package com.emir.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

/**
 * A utility class for browser-related operations.
 */
public class BrowserUtils {

    /**
     * Switches to the window with the expected URL and verifies the expected title.
     *
     * @param driver        WebDriver instance.
     * @param expectedURL   Expected URL to be found in the window.
     * @param expectedTitle Expected title of the window.
     * @return true if the title contains the expectedTitle, false otherwise.
     */
    public static boolean switchWindowAndVerify(WebDriver driver, String expectedURL, String expectedTitle) {
        // Get all window handles
        Set<String> allHandles = driver.getWindowHandles();

        // Iterate through each handle
        for (String eachHandle : allHandles) {
            // Switch to the window
            driver.switchTo().window(eachHandle);
            // Check if the current URL contains the expectedURL
            if (driver.getCurrentUrl().contains(expectedURL)) {
                // If found, break the loop
                break;
            }
        }

        // Return whether the title contains the expectedTitle
        return driver.getTitle().contains(expectedTitle);
    }

    /**
     * Verifies if the title of the current page matches the expected title.
     *
     * @param driver        WebDriver instance.
     * @param expectedTitle Expected title of the page.
     * @return true if the title matches the expected title, false otherwise.
     */
    public static boolean verifyTitle(WebDriver driver, String expectedTitle) {
        // Compare the current title with the expected title
        return driver.getTitle().equals(expectedTitle);
    }

    /**
     * Verifies if the title of the current page contains the expected text.
     *
     * @param driver          WebDriver instance.
     * @param expectedInTitle The text expected to be contained in the title.
     * @return true if the title contains the expected text, false otherwise.
     */
    public static boolean verifyTitleContains(WebDriver driver, String expectedInTitle) {
        // Check if the current title contains the expected text
        return driver.getTitle().contains(expectedInTitle);
    }

    /**
     * Utility method to pause the execution for a specified number of seconds.
     *
     * @param seconds The number of seconds to sleep.
     */
    public static void sleep(int seconds) {
        // Convert seconds to milliseconds
        seconds *= 1000;
        try {
            // Sleep for the specified number of milliseconds
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            // If interrupted while sleeping, catch and ignore the exception
        }
    }

    /**
     * A utility method to wait for the invisibility of a WebElement on the page.
     *
     * @param target The WebElement to wait for invisibility.
     */
    public static void waitForInvisibilityOf(WebElement target) {
        // Initializing WebDriverWait with a timeout of 15 seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Waiting until the target WebElement becomes invisible
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /**
     * A utility method to wait until the title of the current page contains the specified title string.
     *
     * @param title The title string to wait for.
     */
    public static void waitForTitleContains(String title) {
        // Initializing WebDriverWait with a timeout of 15 seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Waiting until the title of the current page contains the specified title string
        wait.until(ExpectedConditions.titleContains(title));
    }
}

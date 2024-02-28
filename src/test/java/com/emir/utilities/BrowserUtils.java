package com.emir.utilities;

import org.openqa.selenium.WebDriver;

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

}
/*
TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
 */

/*
TC #3: Create utility method
1. Create a new method for title verification
2. Create a method to make title verification logic re-usable
3. When method is called, it should simply verify expected title with actual
title
Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle
 */
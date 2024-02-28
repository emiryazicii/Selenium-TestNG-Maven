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

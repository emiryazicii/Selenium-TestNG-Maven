package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;

/**
 * This class demonstrates switching WebDriver to full-screen mode.
 */
public class FullScreenMode {


     //Main method to demonstrate switching WebDriver to full-screen mode.
    public static void main(String[] args) {

        // Navigate to Google website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Maximize the browser window to full-screen
        //Driver.getDriver().manage().window().maximize();

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

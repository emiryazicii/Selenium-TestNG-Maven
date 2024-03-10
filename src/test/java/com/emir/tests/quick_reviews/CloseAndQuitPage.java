package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;

/**
 * This class demonstrates closing and quitting a WebDriver session.
 */
public class CloseAndQuitPage {

    //Main method to demonstrate closing and quitting WebDriver.
    public static void main(String[] args) throws InterruptedException {

        // Navigate to a webpage that opens a new tab
        Driver.getDriver().get(ConfigurationReader.getProperty("env.open.new.tab"));

        // Wait for 5 seconds to observe the opened tab
        Thread.sleep(5000);

        // Close the current tab
        Driver.getDriver().close();

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

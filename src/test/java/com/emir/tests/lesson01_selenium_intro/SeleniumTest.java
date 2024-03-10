package com.emir.tests.lesson01_selenium_intro;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;

/**
 * This class demonstrates a simple Selenium test using ChromeDriver.
 */
public class SeleniumTest {

    public static void main(String[] args) {

        // Get the URL from configuration and navigate to it
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Close the WebDriver instance
        Driver.closeDriver();
    }
}

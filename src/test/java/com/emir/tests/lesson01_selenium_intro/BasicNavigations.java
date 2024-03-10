package com.emir.tests.lesson01_selenium_intro;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;

/**
 * This class demonstrates basic navigation functionalities using Selenium WebDriver.
 */
public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // Navigate to the Tesla website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.tesla"));

        // Print current URL
        System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());

        // Print page title
        System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());

        // Navigate back
        Driver.getDriver().navigate().back();
        BrowserUtils.sleep(1); // Wait for 1 second

        // Navigate forward
        Driver.getDriver().navigate().forward();
        BrowserUtils.sleep(1); // Wait for 1 second

        // Refresh the page
        Driver.getDriver().navigate().refresh();
        BrowserUtils.sleep(1); // Wait for 1 second

        // Navigate to Google website
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("env.google"));

        // Print current URL after navigation
        System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());

        // Print page title after navigation
        System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

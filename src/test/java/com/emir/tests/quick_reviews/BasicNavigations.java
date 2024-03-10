package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;

/**
 * This class demonstrates basic navigations using Selenium WebDriver.
 */
public class BasicNavigations {

     //Main method to demonstrate basic navigations.
    public static void main(String[] args) {

        // Navigate to Etsy website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.etsy"));

        // Navigate to Amazon website
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("env.amazon"));

        // Navigate back to previous page (Etsy)
        Driver.getDriver().navigate().back();

        // Navigate forward to next page (Amazon)
        Driver.getDriver().navigate().forward();

        // Refresh the current page (Amazon)
        Driver.getDriver().navigate().refresh();

        Driver.closeDriver();
    }
}

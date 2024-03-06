package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates basic navigations using Selenium WebDriver.
 */
public class BasicNavigations {


     //Main method to demonstrate basic navigations.
    public static void main(String[] args) {

        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Etsy website
        driver.get(ConfigurationReader.getProperty("env.etsy"));

        // Navigate to Amazon website
        driver.navigate().to(ConfigurationReader.getProperty("env.amazon"));

        // Navigate back to previous page (Etsy)
        driver.navigate().back();

        // Navigate forward to next page (Amazon)
        driver.navigate().forward();

        // Refresh the current page (Amazon)
        driver.navigate().refresh();
    }
}

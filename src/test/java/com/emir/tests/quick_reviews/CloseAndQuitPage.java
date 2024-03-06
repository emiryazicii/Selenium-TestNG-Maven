package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates closing and quitting a WebDriver session.
 */
public class CloseAndQuitPage {

    //Main method to demonstrate closing and quitting WebDriver.
    public static void main(String[] args) throws InterruptedException {

        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to a webpage that opens a new tab
        driver.get(ConfigurationReader.getProperty("env.open.new.tab"));

        // Wait for 5 seconds to observe the opened tab
        Thread.sleep(5000);

        // Close the current tab
        driver.close();

        // Quit the WebDriver session
        driver.quit();
    }
}

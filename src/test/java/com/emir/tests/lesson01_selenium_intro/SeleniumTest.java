package com.emir.tests.lesson01_selenium_intro;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates a simple Selenium test using ChromeDriver.
 */
public class SeleniumTest {

    /**
     * The main method to execute the Selenium test.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Get the URL from configuration and navigate to it
        driver.get(ConfigurationReader.getProperty("env.google"));

        // Close the WebDriver instance
        driver.quit();
    }
}

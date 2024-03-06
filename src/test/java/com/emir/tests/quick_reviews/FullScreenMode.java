package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates switching WebDriver to full-screen mode.
 */
public class FullScreenMode {


     //Main method to demonstrate switching WebDriver to full-screen mode.
    public static void main(String[] args) {

        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window to full-screen
        driver.manage().window().maximize();

        // Navigate to Google website
        driver.get(ConfigurationReader.getProperty("env.google"));

        // Quit the WebDriver session
        driver.quit();
    }
}

package com.emir.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Driver class is a utility class for managing a single WebDriver instance using the Singleton pattern.
 */
public class Driver {

    private static WebDriver driver;

    // Private constructor to prevent instantiation from outside
    private Driver() {}

    /**
     * Get the singleton instance of WebDriver. If the instance is not initialized, it initializes it based on the
     * browser type specified in the configuration.
     *
     * @return The WebDriver instance.
     */
    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type specified in the configuration: " + browserType);
            }

            // Maximize the browser window and set implicit wait
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }

    /**
     * Close the WebDriver instance and reset it to null.
     */
    public static synchronized void closeDriver() {
        if (driver != null) {
            driver.quit(); // Quit the WebDriver instance
            driver = null; // Reset the instance to null
        }
    }
}

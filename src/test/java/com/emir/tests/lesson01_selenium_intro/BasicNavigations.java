package com.emir.tests.lesson01_selenium_intro;

import com.emir.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates basic navigation functionalities using Selenium WebDriver.
 */
public class BasicNavigations {

    /**
     * The main method to execute the basic navigation test.
     * @param args Command line arguments (not used in this example).
     * @throws InterruptedException if the thread sleep is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the Tesla website
        driver.get(ConfigurationReader.getProperty("env.tesla"));

        // Print current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // Print page title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // Navigate back
        driver.navigate().back();
        Thread.sleep(1000); // Wait for 1 second

        // Navigate forward
        driver.navigate().forward();
        Thread.sleep(1000); // Wait for 1 second

        // Refresh the page
        driver.navigate().refresh();
        Thread.sleep(1000); // Wait for 1 second

        // Navigate to Google website
        driver.navigate().to(ConfigurationReader.getProperty("env.google"));

        // Print current URL after navigation
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // Print page title after navigation
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // Close the current browser window
        //driver.close();

        // Quit the WebDriver session
        driver.quit();
    }
}

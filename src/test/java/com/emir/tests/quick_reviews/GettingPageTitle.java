package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates getting and verifying the title of a web page using Selenium WebDriver.
 */
public class GettingPageTitle {


     //Main method to demonstrate getting and verifying page title.
    public static void main(String[] args) {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Cydeo website
        driver.get(ConfigurationReader.getProperty("env.cydeo"));

        // Get the title of the current page
        String pageTitle = driver.getTitle();

        // Print the page title
        System.out.println("Page title = " + pageTitle);

        // Verify if the page title matches the expected title
        if (pageTitle.equals(ConfigurationReader.getProperty("expected.title.cydeo"))) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}

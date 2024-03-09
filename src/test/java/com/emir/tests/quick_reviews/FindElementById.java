package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates finding an element by its ID using Selenium WebDriver.
 */
public class FindElementById {


     //Main method to demonstrate finding an element by ID and performing a click action.
    public static void main(String[] args) {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google website
        driver.get(ConfigurationReader.getProperty("env.google"));

        // Find the element by its ID
        WebElement feelingButton = driver.findElement(By.id("gbqfbb"));

        // Perform a click action on the found element
        feelingButton.click();

        // Quit the WebDriver session
        driver.quit();
    }
}

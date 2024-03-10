package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding an element by its ID using Selenium WebDriver.
 */
public class FindElementById {


     //Main method to demonstrate finding an element by ID and performing a click action.
    public static void main(String[] args) {

        // Navigate to Google website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Find the element by its ID
        WebElement feelingButton = Driver.getDriver().findElement(By.id("gbqfbb"));

        // Perform a click action on the found element
        feelingButton.click();

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

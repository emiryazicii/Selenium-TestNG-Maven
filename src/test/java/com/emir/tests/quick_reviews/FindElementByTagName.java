package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding an element by its tag name and retrieving its text using Selenium WebDriver.
 */
public class FindElementByTagName {


     //Main method to demonstrate finding an element by tag name and retrieving its text.
    public static void main(String[] args) {

        // Navigate to practice environment website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find the header element by its tag name
        WebElement header = Driver.getDriver().findElement(By.tagName("h1"));

        // Get the text of the header element
        String headerText = header.getText();

        // Print the text of the header element
        System.out.println(headerText);

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

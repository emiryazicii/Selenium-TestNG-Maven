package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding an element by its link text and performing a click action using Selenium WebDriver.
 */
public class FindElementByLinkText {


     //Main method to demonstrate finding an element by link text and clicking on it.
    public static void main(String[] args) {

        // Navigate to practice environment website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find the link element by its link text
        WebElement link = Driver.getDriver().findElement(By.linkText("A/B Testing"));

        // Click on the link
        link.click();

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

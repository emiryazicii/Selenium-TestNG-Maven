package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding an element by its partial link text and performing a click action using Selenium WebDriver.
 */
public class FindElementByPartialLinkText {


     //Main method to demonstrate finding an element by partial link text and clicking on it.
    public static void main(String[] args) {

        // Navigate to practice environment website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find the link element by its partial link text
        WebElement link = Driver.getDriver().findElement(By.partialLinkText("A/B"));

        // Click on the link
        link.click();

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

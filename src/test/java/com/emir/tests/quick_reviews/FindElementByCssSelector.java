package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding an element by its CSS selector and verifying its text using Selenium WebDriver.
 */
public class FindElementByCssSelector {


     //Main method to demonstrate finding an element by CSS selector and verifying its text.
    public static void main(String[] args) {

        // Navigate to practice environment website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find the home link element by its CSS selector
        WebElement homeLink = Driver.getDriver().findElement(By.cssSelector("a[class='nav-link']"));

        // Verify if the text of the home link matches the expected text
        if (homeLink.getText().equals(ConfigurationReader.getProperty("link.text"))) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

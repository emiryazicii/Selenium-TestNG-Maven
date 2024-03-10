package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding an element by its name and performing actions on it using Selenium WebDriver.
 */
public class FindElementByName {


    //Main method to demonstrate finding an element by name, entering data, and submitting a form.
    public static void main(String[] args) {

        // Navigate to Google website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Find the search box element by its name
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        // Enter search data into the search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.google"));

        // Submit the search by pressing Enter key
        searchBox.sendKeys(Keys.ENTER);

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates finding an element by its class name and performing actions on it using Selenium WebDriver.
 */
public class FindElementByClassName {


     //Main method to demonstrate finding an element by class name, entering data, and submitting a form.
    public static void main(String[] args) {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google website
        driver.get(ConfigurationReader.getProperty("env.google"));

        // Find the search box element by its class name
        WebElement searchBox = driver.findElement(By.className("gLFyf"));

        // Enter search data into the search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.google"));

        // Submit the search by pressing Enter key
        searchBox.sendKeys(Keys.ENTER);

        // Quit the WebDriver session
        driver.quit();
    }
}

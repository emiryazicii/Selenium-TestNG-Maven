package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates finding an element by its partial link text and performing a click action using Selenium WebDriver.
 */
public class FindElementByPartialLinkText {


     //Main method to demonstrate finding an element by partial link text and clicking on it.
    public static void main(String[] args) {

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to practice environment website
        driver.get(ConfigurationReader.getProperty("env.practice"));

        // Find the link element by its partial link text
        WebElement link = driver.findElement(By.partialLinkText("A/B"));

        // Click on the link
        link.click();

        // Quit the WebDriver session
        driver.quit();
    }
}

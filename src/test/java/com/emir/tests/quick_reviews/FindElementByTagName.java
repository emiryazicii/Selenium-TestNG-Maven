package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates finding an element by its tag name and retrieving its text using Selenium WebDriver.
 */
public class FindElementByTagName {


     //Main method to demonstrate finding an element by tag name and retrieving its text.
    public static void main(String[] args) {

        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to practice environment website
        driver.get(ConfigurationReader.getProperty("env.practice"));

        // Find the header element by its tag name
        WebElement header = driver.findElement(By.tagName("h1"));

        // Get the text of the header element
        String headerText = header.getText();

        // Print the text of the header element
        System.out.println(headerText);

        // Quit the WebDriver session
        driver.quit();
    }
}

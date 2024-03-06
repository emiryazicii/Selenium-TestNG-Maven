package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class demonstrates interacting with checkboxes using Selenium WebDriver.
 */
public class Checkboxes {


     //Main method to demonstrate interacting with checkboxes.
    public static void main(String[] args) {
        // Get the WebDriver instance based on the browser specified in the configuration
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the checkboxes page
        driver.get(ConfigurationReader.getProperty("env.checkboxes"));

        // Find the first checkbox by its ID
        WebElement checkbox1 = driver.findElement(By.id("box1"));

        // Find the second checkbox by its ID
        WebElement checkbox2 = driver.findElement(By.id("box2"));

        // Print the status of the first checkbox before clicking
        System.out.println("Before clicking checkbox1.isSelected() = " + checkbox1.isSelected());

        // Print the status of the second checkbox before clicking
        System.out.println("Before clicking checkbox2.isSelected() = " + checkbox2.isSelected());

        // Click on the first checkbox
        checkbox1.click();

        // Click on the second checkbox
        checkbox2.click();

        // Print the status of the first checkbox after clicking
        System.out.println("After clicking checkbox1.isSelected() = " + checkbox1.isSelected());

        // Print the status of the second checkbox after clicking
        System.out.println("After clicking checkbox2.isSelected() = " + checkbox2.isSelected());

        // Quit the WebDriver session
        driver.quit();
    }
}

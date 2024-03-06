package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class demonstrates interacting with radio buttons using Selenium WebDriver.
 */
public class RadioButtons {


     //Main method to demonstrate interacting with radio buttons.
    public static void main(String[] args) {

        // Get the WebDriver instance based on the browser specified in the configuration
        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the radio buttons page
        driver.get(ConfigurationReader.getProperty("env.radio_buttons"));

        // Find the blue radio button by XPath
        WebElement blueRadioButton = driver.findElement(By.xpath("//input[@id='blue']"));

        // Print the status of the blue radio button
        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());

        // Find the red radio button by XPath
        WebElement redRadioButton = driver.findElement(By.xpath("//input[@id='red']"));

        // Print the status of the red radio button before clicking
        System.out.println("Before clicking redRadioButton.isSelected() = " + redRadioButton.isSelected());

        // Click on the red radio button
        redRadioButton.click();

        // Print the status of the red radio button after clicking
        System.out.println("After clicking redRadioButton.isSelected() = " + redRadioButton.isSelected());

        // Find the green radio button by XPath
        WebElement greenRadioButton = driver.findElement(By.xpath("//input[@id='green']"));

        // Print the status of the green radio button
        System.out.println("greenRadioButton.isSelected() = " + greenRadioButton.isSelected());

        // Click on the green radio button
        greenRadioButton.click();

        // Print the enabled status of the green radio button
        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());

        // Close the browser window
        driver.quit();
    }
}

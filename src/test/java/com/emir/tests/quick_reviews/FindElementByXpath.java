package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates finding elements by XPath and performing actions on them using Selenium WebDriver.
 */
public class FindElementByXpath {


     //Main method to demonstrate finding elements by XPath, performing actions on them, and retrieving element attributes.
    public static void main(String[] args) {

        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to forgot password page
        driver.get(ConfigurationReader.getProperty("env.forgot_password"));

        // Find the email input box by XPath and enter the email data
        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));
        emailBox.sendKeys(ConfigurationReader.getProperty("search.data.email"));

        // Find the button by XPath and click on it
        WebElement button = driver.findElement(By.xpath("//button[@id='form_submit']"));
        button.click();

        // Find the confirmation message by XPath
        WebElement confirmationMessage = driver.findElement(By.xpath("//h4"));

        // Trim both actual and expected messages before comparison
        String actualMessage = confirmationMessage.getText().trim();
        String expectedMessage = ConfigurationReader.getProperty("expected.message2").trim();

        // Compare the actual and expected messages
        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }

        // Retrieve and print the value of the name attribute of the confirmation message element
        System.out.println("Value of the name attribute of the element: " + confirmationMessage.getAttribute("name"));

        // Quit the WebDriver session
        driver.quit();
    }
}

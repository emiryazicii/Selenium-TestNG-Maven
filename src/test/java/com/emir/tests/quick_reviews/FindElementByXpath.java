package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;

import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates finding elements by XPath and performing actions on them using Selenium WebDriver.
 */
public class FindElementByXpath {


     //Main method to demonstrate finding elements by XPath, performing actions on them, and retrieving element attributes.
    public static void main(String[] args) {

        // Navigate to forgot password page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.forgot_password"));

        // Find the email input box by XPath and enter the email data
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        emailBox.sendKeys(ConfigurationReader.getProperty("search.data.email"));

        // Find the button by XPath and click on it
        WebElement button = Driver.getDriver().findElement(By.xpath("//button[@id='form_submit']"));
        button.click();

        // Find the confirmation message by XPath
        WebElement confirmationMessage = Driver.getDriver().findElement(By.xpath("//h4"));

        // Both actual and expected messages for comparison
        String actualMessage = confirmationMessage.getText();
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
        Driver.closeDriver();
    }
}

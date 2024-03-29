package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * This class verifies login functionality on the library website using Selenium WebDriver.
 */
public class LibraryVerification {

    public static void main(String[] args) {

        // Navigate to the library login page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.library"));

        // Find the username input element by class name and enter the username
        WebElement username = Driver.getDriver().findElement(By.className("form-control"));
        username.sendKeys(ConfigurationReader.getProperty("username.login3"));

        // Find the password input element by ID and enter the password
        WebElement password = Driver.getDriver().findElement(By.id("inputPassword"));
        password.sendKeys(ConfigurationReader.getProperty("password.login3"));

        // Find the sign-in button element by tag name and press ENTER to submit the form
        WebElement button = Driver.getDriver().findElement(By.tagName("button"));
        button.sendKeys(Keys.ENTER);

        // Find the alert message element by XPath and verify its text
        WebElement alertMessage = Driver.getDriver().findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div"));
        if(alertMessage.getText().equals(ConfigurationReader.getProperty("expectedData.login3"))){
            System.out.println("Verification Passed!");
        } else {
            System.out.println("Verification Failed");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}
/*
TC #4: Library verifications
1. Open Chrome browser
2. Go to http://library2.cybertekschool.com/login.html
3. Enter username: “incorrect@email.com”
4. Enter password: “incorrect password”
5. Verify: visually “Sorry, Wrong Email or Password” displayed
PS: Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */

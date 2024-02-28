package com.emir.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A utility class for CRM login operations.
 */
public class Crm_Login {

    /**
     * Performs CRM login using predefined username and password.
     *
     * @param driver WebDriver instance.
     */
    public static void login_crm(WebDriver driver) {
        // Find username input box and enter the predefined username
        WebElement usernameBox = driver.findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username.login"));

        // Find password input box and enter the predefined password
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password.login"));

        // Find login button and click it
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
    }

    /**
     * Performs CRM login using custom username and password.
     *
     * @param driver   WebDriver instance.
     * @param username Custom username.
     * @param password Custom password.
     */
    public static void login_crm(WebDriver driver, String username, String password) {
        // Find username input box and enter the custom username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        usernameBox.sendKeys(username);

        // Find password input box and enter the custom password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys(password);

        // Find login button and click it
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
    }
}
/*
TC #5: Create utility method
1. Create a new method for login
2. Create a method to make Task3 logic re-usable
3. When method is called, it should simply login
This method should have at least 2 overloaded versions.
Method #1 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
Method #2 info:
• Name: login_crm()
• Return type: void
• Arg1: WebDriver
• Arg2: String username
• Arg3: String password
 */

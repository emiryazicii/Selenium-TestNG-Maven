package com.emir.tests.lesson03_cssSelector_XPATH;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates the usage of locators and getText() method practice in NextBaseCRM login page.
 */
public class NextBaseCrm_Locators_And_getText_practice {

    public static void main(String[] args) {

        // Navigate to the NextBaseCRM login page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.crm"));

        // Find the username input box by name and enter the username
        WebElement usernameBox = Driver.getDriver().findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username.crm"));

        // Find the password input box by XPath and enter the password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password.crm"));

        // Find the login button by class name and click on it
        WebElement loginButton = Driver.getDriver().findElement(By.className("login-btn"));
        loginButton.click();

        // Find the error message element by class name and verify its text
        WebElement errorText = Driver.getDriver().findElement(By.className("errortext"));
        if(errorText.getText().equals(ConfigurationReader.getProperty("expected.alert2"))){
            System.out.println("Error Message Verification Passed!");
        }else {
            System.out.println("Error Message Verification Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}
/*
TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password
PS: Inspect and decide which locator you should be using to locate web elements
 */

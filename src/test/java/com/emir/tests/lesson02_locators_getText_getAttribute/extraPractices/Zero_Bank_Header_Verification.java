package com.emir.tests.lesson02_locators_getText_getAttribute.extraPractices;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class verifies the header text of the Zero Bank website.
 */
public class Zero_Bank_Header_Verification {

    public static void main(String[] args) {

        // Navigate to Zero Bank website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.zero"));

        // Find the header element and verify its text
        WebElement header = Driver.getDriver().findElement(By.tagName("h3"));
        if (header.getText().equals(ConfigurationReader.getProperty("expectedData.zero"))){
            System.out.println("Header Text Verification Passed!");
        }else{
            System.out.println("Header Text Verification Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}
/*
HWP #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”
 */

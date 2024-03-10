package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates the usage of getText() and getAttribute() methods in Selenium WebDriver.
 */
public class GetText_getAttribute_Practice {

    public static void main(String[] args) {

        // Navigate to the registration form page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.registration"));

        // Find the header element and verify its text
        WebElement header = Driver.getDriver().findElement(By.tagName("h2"));
        if(header.getText().equals(ConfigurationReader.getProperty("expectedData.registration"))){
            System.out.println("Header Text Verification Passed!");
        }else{
            System.out.println("Header Text Verification Failed!");
        }

        // Find the "First name" input box and verify its placeholder attribute value
        WebElement firstnameBox = Driver.getDriver().findElement(By.name("firstname"));
        if(firstnameBox.getAttribute("placeholder").equals(ConfigurationReader.getProperty("expectedData.registration3"))){
            System.out.println("Placeholder Attribute Verification Passed!");
        }else {
            System.out.println("Placeholder Attribute Verification Failed");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}
/*
TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
 */

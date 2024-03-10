package com.emir.tests.lesson03_cssSelector_XPATH;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates the usage of locators, getText(), and getAttribute() methods in NextBaseCRM login page.
 */
public class NextBaseCRM_Locators_getText_getAttribute_practice2 {

    public static void main(String[] args) {

        // Navigate to the NextBaseCRM login page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.crm"));

        // Find the login button by XPath and verify its text
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        if (loginButton.getAttribute("value").equals(ConfigurationReader.getProperty("expected.data.crm4"))) {
            System.out.println("Login Button Text Verification Passed!");
        } else {
            System.out.println("Login Button Text Verification Failed!");
        }

        // Quit the WebDriver session
       Driver.closeDriver();
    }
}
/*
TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
PS: Inspect and decide which locator you should be using to locate web elements.
PS2: Pay attention to where to get the text of this button from
 */

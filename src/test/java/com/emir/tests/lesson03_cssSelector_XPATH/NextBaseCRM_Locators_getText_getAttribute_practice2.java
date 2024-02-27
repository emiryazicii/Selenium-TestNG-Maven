package com.emir.tests.lesson03_cssSelector_XPATH;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates the usage of locators, getText(), and getAttribute() methods in NextBaseCRM login page.
 */
public class NextBaseCRM_Locators_getText_getAttribute_practice2 {

    /**
     * The main method to execute the verification of text and attribute values for elements in NextBaseCRM login page.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to the NextBaseCRM login page
        driver.get(ConfigurationReader.getProperty("env.crm"));

        // Find the login button by XPath and verify its text
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        if (loginButton.getAttribute("value").equals(ConfigurationReader.getProperty("expected.data.crm4"))) {
            System.out.println("Login Button Text Verification Passed!");
        } else {
            System.out.println("Login Button Text Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
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

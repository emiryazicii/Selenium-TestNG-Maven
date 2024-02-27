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
public class NextBaseCrm_Locators_getText_getAttribute_practice {

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

        // Verify the text of the "remember me" label
        WebElement text = driver.findElement(By.className("login-item-checkbox-label"));
        if (text.getText().equals(ConfigurationReader.getProperty("expected.data.crm"))){
            System.out.println("Remember Me Label Text Verification Passed!");
        }else {
            System.out.println("Remember Me Label Text Verification Failed!");
        }

        // Verify the text of the "forgot password" link
        WebElement link = driver.findElement(By.partialLinkText("FORGOT"));
        System.out.println("Forgot Password Link Text: " + link.getText());
        if(link.getText().equals(ConfigurationReader.getProperty("expected.data.crm2"))){
            System.out.println("Forgot Password Link Text Verification Passed!");
        }else{
            System.out.println("Forgot Password Link Text Verification Failed!");
        }

        // Verify the href attribute value of the "forgot password" link
        if (link.getAttribute("href").contains(ConfigurationReader.getProperty("expected.data.crm3"))){
            System.out.println("Forgot Password Link Href Verification Passed!");
        }else {
            System.out.println("Forgot Password Link Href Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes
PS: Inspect and decide which locator you should be using to locate web elements
 */

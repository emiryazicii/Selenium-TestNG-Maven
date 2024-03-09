package com.emir.tests.lesson03_cssSelector_XPATH.extraPractices;

import com.emir.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class verifies the header text of the Zero Bank login page.
 */
public class Zero_Bank_Header_Verification {

    /**
     * The main method to execute the verification of the Zero Bank header text.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to the Zero Bank login page
        driver.get(ConfigurationReader.getProperty("env.zero"));

        //WebElement header = driver.findElement(By.xpath("//h3"));

        // Find the header element by CSS selector and verify its text
        WebElement header = driver.findElement(By.cssSelector("h3"));
        if (header.getText().equals(ConfigurationReader.getProperty("expectedData.zero"))) {
            System.out.println("Header Text Verification Passed!");
        } else {
            System.out.println("Header Text Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
HWP #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank
 */

package com.emir.tests.lesson02_locators_getText_getAttribute.extraPractices;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates back and forth navigation between Google and Gmail using Selenium WebDriver.
 */
public class Back_And_Forth_Navigation {

    /**
     * The main method to execute the back and forth navigation test.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to Google website
        driver.get(ConfigurationReader.getProperty("env.google"));

        // Find the Gmail link and click on it
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        // Get the current title and verify if it contains the expected title for Gmail
        String currentTitle = driver.getTitle();
        if(currentTitle.contains(ConfigurationReader.getProperty("expectedData.google"))){
            System.out.println("Title Verification Passed!");
        }else{
            System.out.println("Title Verification Failed!");
        }

        // Navigate back to the previous page (Google)
        driver.navigate().back();

        // Get the current title and verify if it equals the expected title for Google
        currentTitle = driver.getTitle();
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.google2"))){
            System.out.println("Title Verification Passed!");
        }else {
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */

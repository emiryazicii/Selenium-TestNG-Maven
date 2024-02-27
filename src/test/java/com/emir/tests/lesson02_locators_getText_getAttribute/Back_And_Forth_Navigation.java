package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates back and forth navigation using Selenium WebDriver.
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

        // Navigate to the Cydeo Practice Tool website
        driver.get(ConfigurationReader.getProperty("env.practice"));

        // Find and click the link with partial text "A/B"
        WebElement link = driver.findElement(By.partialLinkText("A/B"));
        link.click();

        // Get the current title after clicking the link
        String currentTitle = driver.getTitle();

        // Verify if title equals "No A/B Test" and print the result
        if(currentTitle.equals("No A/B Test")){
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed");
        }

        // Navigate back to the previous page
        driver.navigate().back();

        // Get the current title after navigating back
        currentTitle = driver.getTitle();

        // Verify if title equals "Practice" and print the result
        if(currentTitle.equals("Practice")){
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */

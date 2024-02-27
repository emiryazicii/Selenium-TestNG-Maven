package com.emir.tests.lesson02_locators_getText_getAttribute.extraPractices;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates using the class name locator to locate and click on a link, then verify the title.
 */
public class Practice_Cydeo_Class_Locator_Practice {

    /**
     * The main method to execute the class locator practice test for Practice Cydeo.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to the Practice Cydeo Inputs page
        driver.get(ConfigurationReader.getProperty("env.inputs"));

        // Find the "Home" link element by class name and click on it
        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        // Get the current title and verify if it matches the expected title
        String currentTitle = driver.getTitle();
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.title"))){
            System.out.println("Title Verification Passed!");
        }else{
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “className” locator
 */

package com.emir.tests.lesson02_locators_getText_getAttribute.extraPractices;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class verifies the title of the Etsy website after searching for a specific item.
 */
public class Etsy_Title_Verification {

    /**
     * The main method to execute the title verification test for Etsy.
     * @param args Command line arguments (not used in this example).
     * @throws InterruptedException if the thread sleep is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to Etsy website
        driver.get(ConfigurationReader.getProperty("env.etsy"));

        // Wait for 5 seconds for the page to load
        Thread.sleep(5000);

        // Find the search box element and enter the search query
        WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.etsy") + Keys.ENTER);

        // Wait for 3 seconds for the search results to load
        Thread.sleep(3000);

        // Get the current title of the page
        String currentTitle = driver.getTitle();

        // Verify if the title matches the expected title
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.etsy"))){
            System.out.println("Title Verification Passed!");
        }else{
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
HWP #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”
 */

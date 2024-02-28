package com.emir.tests.lesson03_cssSelector_XPATH.extraPractices;

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
     * The main method to execute the verification of the Etsy website title.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to the Etsy website
        driver.get(ConfigurationReader.getProperty("env.etsy"));

        // Find the search box element by XPath and enter the search query
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.etsy") + Keys.ENTER);

        //WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));

        //WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));

        //WebElement searchBox = driver.findElement(By.cssSelector("input[data-id='search-query']"));

        // Get the current title of the webpage
        String currentTitle = driver.getTitle();

        // Verify if the title matches the expected title
        if (currentTitle.equals(ConfigurationReader.getProperty("expectedData.etsy"))) {
            System.out.println("Title Verification Passed!");
        } else {
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

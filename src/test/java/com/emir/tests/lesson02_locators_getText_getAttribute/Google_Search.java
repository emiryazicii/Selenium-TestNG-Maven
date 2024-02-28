package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates searching on Google and verifying the title using Selenium WebDriver.
 */
public class Google_Search {

    /**
     * The main method to execute the Google search test.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to Google homepage
        driver.get(ConfigurationReader.getProperty("env.google"));

        // Find the search box element by its ID
        WebElement searchBox = driver.findElement(By.name("q")); // Updated to use the correct ID

        // Type the search data into the search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.google"));

        // Press ENTER key to perform the search
        searchBox.sendKeys(Keys.ENTER);

        // Get the current title of the page
        String currentTitle = driver.getTitle();

        // Verify if the title starts with the search data and print the result
        if(currentTitle.startsWith(ConfigurationReader.getProperty("searchData.google"))){
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
    }
}
/*
TC#3: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Press ENTER to search
5- Verify title:
Expected: Title should start with “apple” word
 */

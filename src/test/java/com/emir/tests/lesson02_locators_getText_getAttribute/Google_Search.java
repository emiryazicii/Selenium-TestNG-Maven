package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates searching on Google and verifying the title using Selenium WebDriver.
 */
public class Google_Search {

    public static void main(String[] args) {

        // Navigate to Google homepage
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Find the search box element by its ID
        WebElement searchBox = Driver.getDriver().findElement(By.name("q")); // Updated to use the correct ID

        // Type the search data into the search box
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.google"));

        // Press ENTER key to perform the search
        searchBox.sendKeys(Keys.ENTER);

        // Get the current title of the page
        String currentTitle = Driver.getDriver().getTitle();

        // Verify if the title starts with the search data and print the result
        if(currentTitle.startsWith(ConfigurationReader.getProperty("searchData.google"))){
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
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

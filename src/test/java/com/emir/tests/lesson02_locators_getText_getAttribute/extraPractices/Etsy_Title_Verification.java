package com.emir.tests.lesson02_locators_getText_getAttribute.extraPractices;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * This class verifies the title of the Etsy website after searching for a specific item.
 */
public class Etsy_Title_Verification {

    public static void main(String[] args) throws InterruptedException {

        // Navigate to Etsy website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.etsy"));

        // Wait for 5 seconds for the page to load
        BrowserUtils.sleep(5);

        // Find the search box element and enter the search query
        WebElement searchBox = Driver.getDriver().findElement(By.id("global-enhancements-search-query"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.etsy") + Keys.ENTER);

        // Wait for 3 seconds for the search results to load
        BrowserUtils.sleep(3);

        // Get the current title of the page
        String currentTitle = Driver.getDriver().getTitle();

        // Verify if the title matches the expected title
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.etsy"))){
            System.out.println("Title Verification Passed!");
        }else{
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
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

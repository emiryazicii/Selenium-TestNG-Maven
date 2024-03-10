package com.emir.tests.lesson03_cssSelector_XPATH.extraPractices;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * This class verifies the title of the Etsy website after searching for a specific item.
 */
public class Etsy_Title_Verification {

    public static void main(String[] args) {

        // Navigate to the Etsy website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.etsy"));

        // Find the search box element by XPath and enter the search query
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.etsy") + Keys.ENTER);

        //WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));

        //WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));

        //WebElement searchBox = driver.findElement(By.cssSelector("input[data-id='search-query']"));

        // Get the current title of the webpage
        String currentTitle = Driver.getDriver().getTitle();

        // Verify if the title matches the expected title
        if (currentTitle.equals(ConfigurationReader.getProperty("expectedData.etsy"))) {
            System.out.println("Title Verification Passed!");
        } else {
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

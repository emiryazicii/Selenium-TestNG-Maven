package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TestNG_DataProvider class contains test methods to validate Google search functionality.
 */
public class TestNG_DataProvider {

    /**
     * Test method to perform a Google search and validate search results.
     * It navigates to the Google search page, enters a search term, submits the search, and verifies the search results page title.
     */
    @Test
    public void test_google_search(){

        // Navigate to Google search page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Locate the search box and enter search term
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys(ConfigurationReader.getProperty("search.data.google")+ Keys.ENTER);

        // Verify the page title
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigurationReader.getProperty("search.data.google") + " - Google Search");

        // Close the WebDriver instance
        Driver.closeDriver();
    }
}

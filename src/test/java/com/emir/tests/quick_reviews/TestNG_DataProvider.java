package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * TestNG_DataProvider class contains test methods to validate Google search functionality.
 */
public class TestNG_DataProvider {

    /**
     * Test method to perform a Google search and validate search results using data provider.
     * It navigates to the Google search page, enters a search term, submits the search, and verifies the search results page title.
     * @param keyword The search term to be entered in the search box.
     * @param expectedResult The expected title of the search results page.
     */
    @Test(dataProvider = "googleSearchData")
    public void test_google_search(String keyword, String expectedResult){

        // Navigate to Google search page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        // Locate the search box and enter search term
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys(keyword+ Keys.ENTER);

        // Verify the page title
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedResult);

        // Close the WebDriver instance
        Driver.closeDriver();
    }

    /**
     * Data provider method to provide test data for the Google search test.
     * @return Two-dimensional array of test data where each row contains the search keyword and the expected search results page title.
     */
    @DataProvider(name = "googleSearchData")
    public Object[][] testData(){

        return new Object[][]{

                {ConfigurationReader.getProperty("search.data.google"), ConfigurationReader.getProperty("search.data.google") + " - Google Search"},
                {ConfigurationReader.getProperty("search.data.google2"), ConfigurationReader.getProperty("search.data.google2") + " - Google Search"},
                {ConfigurationReader.getProperty("search.data.google3"), ConfigurationReader.getProperty("search.data.google3") + " - Google Search"},
                {ConfigurationReader.getProperty("search.data.google4"), ConfigurationReader.getProperty("search.data.google4") + " - Google Search"}

        };
    }
}

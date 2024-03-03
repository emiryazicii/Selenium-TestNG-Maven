package com.emir.tests.lesson09_review_javafaker_driverUtil;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * A test class to practice using the Driver utility class.
 */
public class DriverUtilPractice {

    /**
     * Test method to perform a Bing search using the Driver utility class.
     */
    @Test
    public void test_bing_search() {
        // Navigate to the Bing search page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.bing"));

        // Find the search box and enter the search keyword
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//textarea[@id='sb_form_q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.bing"));

        // Wait for 2 seconds
        BrowserUtils.sleep(2);

        // Press Enter key
        searchBox.sendKeys(Keys.ENTER);

        // Verify the title of the search results page
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigurationReader.getProperty("searchData.bing") + " - Search");
    }

    /**
     * Teardown method to close the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Close WebDriver
        Driver.closeDriver();
    }
}


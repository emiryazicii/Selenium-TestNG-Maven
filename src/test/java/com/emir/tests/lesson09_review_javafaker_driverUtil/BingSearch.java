package com.emir.tests.lesson09_review_javafaker_driverUtil;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * A test class to perform Bing search.
 */
public class BingSearch {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the Bing search page.
     */
    @BeforeMethod
    public void setupMethod() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the Bing search page
        driver.get(ConfigurationReader.getProperty("env.bing"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }

    /**
     * Test method to perform a Bing search and verify the title.
     */
    @Test
    public void test_bing_search() {
        // Find the search box and enter the search keyword
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.bing"));

        // Wait for 2 seconds
        BrowserUtils.sleep(2);

        // Press Enter key
        searchBox.sendKeys(Keys.ENTER);

        // Verify the title of the search results page
        Assert.assertEquals(driver.getTitle(), ConfigurationReader.getProperty("searchData.bing") + " - Search");
    }
}
/*
TC #1: Bing search
1- Open a chrome browser
2- Go to: https://bing.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */
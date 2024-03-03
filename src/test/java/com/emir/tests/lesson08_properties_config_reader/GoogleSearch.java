package com.emir.tests.lesson08_properties_config_reader;

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
 * A test class to perform Google search.
 */
public class GoogleSearch {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the Google search page.
     */
    @BeforeMethod
    public void setupMethod() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the Google search page
        driver.get(ConfigurationReader.getProperty("env.google"));
    }

    /**
     * Teardown method to close the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Close WebDriver
        driver.quit();
    }

    /**
     * Test method to perform a Google search and verify the title.
     */
    @Test
    public void google_search_test() {
        // Find the search box and enter the search keyword
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.google") + Keys.ENTER);

        // Verify the title of the search results page
        Assert.assertEquals(driver.getTitle(), ConfigurationReader.getProperty("searchData.google") + " - Google Search");
    }
}
/*
TC #4: Google search
1- Open a chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Google Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */


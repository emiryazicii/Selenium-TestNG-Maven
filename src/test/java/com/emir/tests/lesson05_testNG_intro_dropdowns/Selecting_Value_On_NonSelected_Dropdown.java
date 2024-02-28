package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class to select a value from a non-select dropdown and verify the result.
 */
public class Selecting_Value_On_NonSelected_Dropdown {

    WebDriver driver;

    /**
     * Method to set up the WebDriver instance before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Get the WebDriver instance based on the browser type specified in the configuration
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to the dropdown page
        driver.get(ConfigurationReader.getProperty("env.dropdown"));
    }

    /**
     * Method to quit the WebDriver instance after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver instance
        driver.quit();
    }

    /**
     * Test method to select a value from a non-select dropdown and verify the result.
     */
    @Test
    public void non_select_dropdown_test(){
        // Find the non-select dropdown element
        WebElement nonSelectDropdown = driver.findElement(By.cssSelector("a[role='button']"));

        // Click the non-select dropdown
        nonSelectDropdown.click();

        // Find and click on the "Facebook" option
        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebook.click();

        // Get the current title of the page
        String currentTitle = driver.getTitle();

        // Verify that the current title matches the expected title for Facebook
        Assert.assertEquals(currentTitle, ConfigurationReader.getProperty("expected.data.facebook"));
    }
}
/*
TC #8: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - log in or sign up
 */

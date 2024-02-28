package com.emir.tests.lesson07_webtables_utilities_javafaker;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

/**
 * A test class to practice window handling in Selenium WebDriver.
 */
public class WindowHandlePractice {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the Amazon website.
     */
    @BeforeMethod
    public void setupMethod() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to Amazon website
        driver.get(ConfigurationReader.getProperty("env.amazon"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void TearDown() {
        // Quit WebDriver
        driver.quit();
    }

    /**
     * Test method to practice window handling.
     * It opens new tabs using JavaScriptExecutor, switches to the tab where Etsy.com is open, and asserts the title.
     */
    @Test
    public void testing_window_handles() {
        // Open new tabs using JavaScriptExecutor
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        // Get all window handles
        Set<String> allHandles = driver.getWindowHandles();

        // Iterate through each handle
        for (String eachHandle : allHandles) {
            // Switch to the window
            driver.switchTo().window(eachHandle);
            // Check if the current URL contains Etsy.com
            if (driver.getCurrentUrl().contains(ConfigurationReader.getProperty("expectedData.etsy2"))) {
                // Break the loop if Etsy.com is found
                break;
            }
        }

        // Assert that the title contains "Etsy"
        //Assert.assertTrue(driver.getTitle().contains(ConfigurationReader.getProperty("expectedData.etsy3")));
        Assert.assertTrue(BrowserUtils.verifyTitleContains(driver,"Etsy"));
    }

    /**
     * Another test method to practice window handling using BrowserUtils.
     * It opens new tabs using JavaScriptExecutor and asserts the title using BrowserUtils.
     */
    @Test
    public void testing_window_handles2() {
        // Open new tabs using JavaScriptExecutor
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        // Assert that the title contains "Etsy" using BrowserUtils
        Assert.assertTrue(BrowserUtils.switchWindowAndVerify(driver, "etsy", "Etsy"));
    }
}
/*
TC #1: Window Handle practice
1. Create new test and make set ups
2. Go to : https://www.amazon.com
3. Copy paste the lines from below into your class
4. Create a logic to switch to the tab where Etsy.com is open
5. Assert: Title contains “Etsy”
Lines to be pasted:
((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
These lines will simply open new tabs using something called JavascriptExecutor
and get those pages. We will learn JavascriptExecutor later as well.
 */

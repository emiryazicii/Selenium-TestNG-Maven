package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class to verify the title of the Cydeo website.
 */
public class Cydeo_Title_Verification {

    WebDriver driver;

    /**
     * Method to set up the WebDriver instance before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to Cydeo website
        driver.get(ConfigurationReader.getProperty("env.cydeo"));
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
     * Test method to verify the title of the Cydeo website.
     */
    @Test
    public void cydeo_title_verification(){
        // Verify title
        Assert.assertEquals(driver.getTitle(), ConfigurationReader.getProperty("expected.title.cydeo"));
    }
}
/*
TC #4: Cydeo Title Verification
1. Open Chrome browser
2. Go to https://www.cydeo.com
3. Verify title:
Expected: Cydeo
 */

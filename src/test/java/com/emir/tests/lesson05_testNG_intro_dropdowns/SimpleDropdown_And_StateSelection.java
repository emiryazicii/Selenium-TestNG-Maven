package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class to verify the default selected values in the dropdowns.
 */
public class SimpleDropdown_And_StateSelection {

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
     * Test method to verify the default selected value in the simple dropdown.
     */
    @Test
    public void simple_dropdown_test(){
        // Initialize the Select element for the simple dropdown
        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        // Verify the default selected value
        Assert.assertEquals(simpleDropdown.getFirstSelectedOption().getText(), ConfigurationReader.getProperty("expected.data.dropdown"));
    }

    /**
     * Test method to verify the default selected value in the state selection dropdown.
     */
    @Test
    public void state_selection_test(){
        // Initialize the Select element for the state selection dropdown
        Select stateSelection = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        // Verify the default selected value
        Assert.assertEquals(stateSelection.getFirstSelectedOption().getText(), ConfigurationReader.getProperty("expected.data.selection"));
    }
}
/*
TC#5: Verifying “Simple dropdown” and “State selection” dropdown
default values
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State
 */

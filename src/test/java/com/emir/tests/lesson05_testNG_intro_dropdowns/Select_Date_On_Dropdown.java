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
 * Test class to select a date on dropdowns and verify the selection.
 */
public class Select_Date_On_Dropdown {

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
     * Test method to select a date on dropdowns and verify the selection.
     */
    @Test
    public void dateDropdown_Test(){
        // Initialize Select elements for year, month, and day dropdowns
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        // Select year, month, and day
        yearDropdown.selectByVisibleText("1933");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        // Verify the selected values
        Assert.assertEquals(yearDropdown.getFirstSelectedOption().getText(), ConfigurationReader.getProperty("expected.data.dropdown.year"));
        Assert.assertEquals(monthDropdown.getFirstSelectedOption().getText(), ConfigurationReader.getProperty("expected.data.dropdown.month"));
        Assert.assertEquals(dayDropdown.getFirstSelectedOption().getText(), ConfigurationReader.getProperty("expected.data.dropdown.day"));
    }
}
/*
TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1933” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number
 */

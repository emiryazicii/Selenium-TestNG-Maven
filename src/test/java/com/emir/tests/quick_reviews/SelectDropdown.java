package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class demonstrates testing a dropdown menu using the Select class.
 */
public class SelectDropdown {

    WebDriver driver;

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Initialize WebDriver instance
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        driver.quit();
    }

    /**
     * Test method to test selecting an option from a dropdown menu.
     */
    @Test
    public void select_dropdown_test(){
        // Navigate to the page with dropdown menu
        driver.get(ConfigurationReader.getProperty("env.dropdown"));

        // Initialize Select object with the dropdown element
        Select simpleSelect = new Select(driver.findElement(By.id("dropdown")));

        // Select an option by visible text
        simpleSelect.selectByVisibleText("Option 2");
    }
}

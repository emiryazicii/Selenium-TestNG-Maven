package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates testing a dropdown menu using the Select class.
 */
public class SelectDropdown {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with dropdown menu
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dropdown"));
    }

    /**
     * Test method to test selecting an option from a dropdown menu.
     */
    @Test
    public void select_dropdown_test(){


        // Initialize Select object with the dropdown element
        Select simpleSelect = new Select(Driver.getDriver().findElement(By.id("dropdown")));

        // Select an option by visible text
        simpleSelect.selectByVisibleText("Option 2");
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

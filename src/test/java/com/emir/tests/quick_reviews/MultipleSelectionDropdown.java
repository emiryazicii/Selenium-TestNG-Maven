package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates testing a multiple selection dropdown menu using the Select class.
 */
public class MultipleSelectionDropdown {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with the multiple selection dropdown menu
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dropdown"));
    }

    /**
     * Test method to test selecting multiple options from a dropdown menu.
     */
    @Test
    public void multiple_selection_dropdown_test(){

        // Initialize Select object with the dropdown element
        Select multiSelect = new Select(Driver.getDriver().findElement(By.name("Languages")));

        // Print whether the dropdown allows multiple selection
        System.out.println("multiSelect.isMultiple() = " + multiSelect.isMultiple());

        // Select options by value, visible text, and index
        multiSelect.selectByValue("java");
        multiSelect.selectByVisibleText("Python");
        multiSelect.selectByIndex(2);

        // Deselect all selected options
        multiSelect.deselectAll();
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

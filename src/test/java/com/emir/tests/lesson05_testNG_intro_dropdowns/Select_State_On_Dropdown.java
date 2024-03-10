package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class to select a state from the dropdown and verify the result.
 */
public class Select_State_On_Dropdown {

    /**
     * Method to set up the WebDriver instance before each test method.
     */
    @BeforeMethod
    public void setupMethod(){

        // Navigate to the dropdown page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dropdown"));
    }

    /**
     * Test method to select a state from the dropdown and verify the result.
     */
    @Test
    public void select_state_test(){
        // Initialize Select element for the state dropdown
        Select stateSelection = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));

        // Select states using different methods
        stateSelection.selectByVisibleText("Illinois");
        stateSelection.selectByValue("VA");
        stateSelection.selectByIndex(5);

        // Verify the final selected option
        Assert.assertEquals(stateSelection.getFirstSelectedOption().getText(), ConfigurationReader.getProperty("expected.data.dropdown.state"));
    }

    /**
     * Method to quit the WebDriver instance after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver instance
        Driver.closeDriver();
    }
}
/*
TC #7: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
 */

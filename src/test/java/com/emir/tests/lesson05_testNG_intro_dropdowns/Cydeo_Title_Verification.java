package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class to verify the title of the Cydeo website.
 */
public class Cydeo_Title_Verification {

    /**
     * Method to set up the WebDriver instance before each test method.
     */
    @BeforeMethod
    public void setupMethod(){

        // Navigate to Cydeo website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.cydeo"));
    }

    /**
     * Test method to verify the title of the Cydeo website.
     */
    @Test
    public void cydeo_title_verification(){
        // Verify title
        Assert.assertEquals(Driver.getDriver().getTitle(), ConfigurationReader.getProperty("expected.title.cydeo"));
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
TC #4: Cydeo Title Verification
1. Open Chrome browser
2. Go to https://www.cydeo.com
3. Verify title:
Expected: Cydeo
 */

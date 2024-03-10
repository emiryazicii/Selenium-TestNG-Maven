package com.emir.tests.lesson08_properties_config_reader;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import com.emir.utilities.WebTableUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * A test class to verify methods in the WebTableUtils class.
 */
public class WebTableUtilsMethodTest2 {

    /**
     * Setup method to initialize the WebDriver and navigate to the web table page.
     */
    @BeforeMethod
    public void setupMethod() {

        // Navigate to web table page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.webTables"));
    }

    /**
     * Test method to verify the order date of a customer.
     */
    @Test
    public void testing_order_date() {
        // Verify if the order date of Samuel Jackson matches the expected date
        Assert.assertTrue(WebTableUtils.verifyOrderDate("Samuel Jackson", "12/21/2021"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        Driver.closeDriver();
    }
}

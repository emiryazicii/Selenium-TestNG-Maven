package com.emir.tests.lesson08_properties_config_reader;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import com.emir.utilities.WebDriverFactory;
import com.emir.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * A test class to practice using WebTableUtils methods.
 */
public class WebTableUtilsMethodPractice3 {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the web table page.
     */
    @BeforeMethod
    public void setupMethod() {

        // Navigate to the web table page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.tables"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
       Driver.closeDriver();
    }

    /**
     * Test method to verify the email cell value in the web table.
     */
    @Test
    public void testing_email_cell() {
        // Verify if the email retrieved from the table matches the expected email
        Assert.assertEquals(WebTableUtils.getEmailFromTable("2", "Jason"),
                ConfigurationReader.getProperty("testData.email2"));
    }
}

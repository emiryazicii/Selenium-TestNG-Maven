package com.emir.tests.lesson08_properties_config_reader;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import com.emir.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * A test class to verify methods in the WebTableUtils class.
 */
public class WebTableUtilsMethodTest {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the web table page.
     */
    @BeforeMethod
    public void setupMethod() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to web table page
        driver.get(ConfigurationReader.getProperty("env.webTables"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }

    /**
     * Test method to verify the order date returned by the WebTableUtils class.
     */
    @Test
    public void testing_order_date() {
        // Verify the order date returned by the WebTableUtils for John Doe
        Assert.assertEquals(WebTableUtils.returnOrderDate(driver, "John Doe"), ConfigurationReader.getProperty("customer.order.date2"));
    }
}

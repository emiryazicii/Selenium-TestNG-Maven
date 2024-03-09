package com.emir.tests.base;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

/**
 * This class serves as a base class for other test classes.
 * It provides methods for setting up and tearing down the WebDriver instance.
 */
public abstract class TestBase {

    protected WebDriver driver;

    /**
     * Setup method executed before each test method.
     * It initializes the WebDriver instance, maximizes the window, and sets implicit wait timeout.
     */
    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));
    }

    /**
     * Teardown method executed after each test method.
     * It quits the WebDriver session.
     */
    @AfterMethod
    public void tearDown(){
        Driver.getDriver().quit();
    }
}

package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class demonstrates testing JavaScript alerts.
 */
public class JavaScriptAlerts {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with JavaScript alerts
        Driver.getDriver().get(ConfigurationReader.getProperty("env.alerts"));
    }

    /**
     * Test method to test handling JavaScript alerts.
     */
    @Test
    public void js_alerts_test(){

        // Find the button to trigger the alert
        WebElement jsAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));

        // Click on the button to trigger the alert
        jsAlert.click();

        // Switch to the alert and accept it
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
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

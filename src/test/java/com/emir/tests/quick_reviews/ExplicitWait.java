package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class tests explicit waits using WebDriverWait.
 */
public class ExplicitWait {

    /**
     * Test method for explicit waits using WebDriverWait.
     */
    @Test
    public void explicit_wait_test(){
        // Open the explicit wait page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.explicitWait"));

        // Find the start button and click on it
        WebElement startButton = Driver.getDriver().findElement(By.xpath("//button[.='Start']"));
        startButton.click();

        // Initialize WebDriverWait with a timeout of 15 seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Find the "Hello World!" element
        WebElement helloWorld = Driver.getDriver().findElement(By.xpath("(//h4)[2]"));

        // Wait for the "Hello World!" element to be visible
        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        // Assert that the "Hello World!" element is displayed
        Assert.assertTrue(helloWorld.isDisplayed());

        // Close the browser session
        Driver.closeDriver();
    }
}

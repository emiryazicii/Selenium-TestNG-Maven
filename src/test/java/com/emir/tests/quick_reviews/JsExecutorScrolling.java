package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * This class tests scrolling using JavascriptExecutor.
 */
public class JsExecutorScrolling {

    /**
     * Test method for scrolling using JavascriptExecutor.
     */
    @Test
    public void js_executor_scrolling_test(){
        // Open the practice page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find the CYDEO link
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        // Create JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Scroll the CYDEO link into view
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);

        // Close the browser session
        Driver.closeDriver();
    }
}

package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for practicing scrolling using JavaScriptExecutor.
 */
public class JavaScriptExecutorPractice {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the infinite scroll page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.infiniteScroll"));
    }

    /**
     * Method to clean up the test environment after each test method.
     */
    @AfterMethod
    public void tearDown() {
        // Closing the browser
        Driver.closeDriver();
    }

    /**
     * Test case for scrolling using JavaScriptExecutor.
     */
    @Test
    public void test_jsExecutor() {
        // Creating a JavaScriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Scrolling 750 pixels down 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");
        }

        // Scrolling 750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");
        }
    }
}
/*
TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a. 750 pixels down 10 times.
b. 750 pixels up 10 times
JavaScript method to use : window.scrollBy(0,0)
 */
package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for practicing scrolling using JavaScriptExecutor.
 */
public class JavaScriptExecutorPractice2 {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the large page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.large"));
    }

    /**
     * Test case for scrolling to specific elements using JavaScriptExecutor.
     */
    @Test
    public void test_jsExecutor() {
        // Creating a JavaScriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Locating the elements to scroll to
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        // Introducing a sleep pause to allow for better visualization
        BrowserUtils.sleep(1);

        // Scrolling to the CYDEO link
        js.executeScript("arguments[0].scrollIntoView(true);", cydeoLink);

        // Introducing another sleep pause to allow for better visualization
        BrowserUtils.sleep(1);

        // Scrolling to the Home link
        js.executeScript("arguments[0].scrollIntoView(true);", homeLink);
    }

    /**
     * Method to clean up the test environment after each test method.
     */
    @AfterMethod
    public void tearDown() {
        // Closing the browser
        Driver.closeDriver();
    }
}
/*
TC #7: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/large
3- Scroll down to “Cydeo” link
4- Scroll up to “Home” link
5- Use below provided JS method only
JavaScript method to use : arguments[0].scrollIntoView(true)
Note: You need to locate the links as web elements and pass them as
arguments into executeScript() method
 */
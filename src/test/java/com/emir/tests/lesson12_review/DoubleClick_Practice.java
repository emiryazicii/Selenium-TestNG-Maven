package com.emir.tests.lesson12_review;

import com.emir.pages.W3Page;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class DoubleClick_Practice {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the W3Schools page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.w3"));
    }

    /**
     * Test case for double-clicking on a text to change its color.
     */
    @Test
    public void test_double_click() {
        // Creating an instance of W3Page
        W3Page w3Page = new W3Page();

        // Creating an Actions object
        Actions actions = new Actions(Driver.getDriver());

        // Creating a WebDriverWait object
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Switching to the iframe
        Driver.getDriver().switchTo().frame("iframeResult");

        // Performing double-click action on the paragraph element
        actions.doubleClick(w3Page.paragraph).perform();

        // Waiting until the paragraph's style attribute value contains "color: red;"
        wait.until(ExpectedConditions.attributeContains(w3Page.paragraph, "style", "color: red;"));

        // Verifying that the paragraph's style attribute value contains "color: red;"
        Assert.assertTrue(w3Page.paragraph.getAttribute("style").contains(ConfigurationReader.getProperty("expected.attribute.value.part")));
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
TC #1: Double Click Test
1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
2. Switch to iframe.
3. Double click on the text “Double-click me to change my text color.”
4. Assert: Text’s “style” attribute value contains “red”.
NOTE: FOLLOW POM
 */
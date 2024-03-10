package com.emir.tests.lesson12_review;

import com.emir.pages.DynamicControlsPage;
import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for practicing explicit waits using TestNG and Page Object Model (POM).
 */
public class ExplicitWaitPractice {

    private DynamicControlsPage dynamicControlsPage;

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Navigate to the Dynamic Controls page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dynamic.controls"));
        // Initialize the DynamicControlsPage object
        dynamicControlsPage = new DynamicControlsPage();
    }

    /**
     * Test case to verify the functionality of removing a checkbox.
     */
    @Test
    public void test_remove_checkbox() {
        // Click on the Remove button
        dynamicControlsPage.removeButton.click();
        // Wait until the loading bar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        try {
            // Assert that the checkbox is not displayed
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        } catch (NoSuchElementException e) {
            // Catch the NoSuchElementException if the checkbox is not found
            e.printStackTrace();
            // Print the exception and assert true to indicate that the test passed
            Assert.assertTrue(true);
        }

        // Assert that the message "It's gone!" is displayed
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
    }

    /**
     * Test case to verify the functionality of enabling an input box.
     */
    @Test
    public void test_enable_input_box() {
        // Click on the Enable button
        dynamicControlsPage.enableButton.click();
        // Wait until the loading bar disappears
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        // Assert that the input box is enabled
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        // Assert that the message "It's enabled!" is displayed
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        // Assert that the message text is as expected
        Assert.assertEquals(dynamicControlsPage.message.getText(), ConfigurationReader.getProperty("expected.message"));
    }

    /**
     * Method to clean up the test environment after each test method.
     */
    @AfterMethod
    public void tearDown() {
        // Close the browser
        Driver.closeDriver();
    }
}
/*
TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.
NOTE: FOLLOW POM

TC #3: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Enable” button
4- Wait until “loading bar disappears”
5- Verify:
a. Input box is enabled.
b. “It’s enabled!” message is displayed.
NOTE: FOLLOW POM
 */
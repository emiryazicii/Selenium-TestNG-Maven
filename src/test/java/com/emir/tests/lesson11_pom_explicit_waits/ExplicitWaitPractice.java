package com.emir.tests.lesson11_pom_explicit_waits;

import com.emir.pages.DynamicLoad7Page;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class for practicing explicit waits.
 */
public class ExplicitWaitPractice {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Opening the explicit wait page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.explicitWait2"));
    }

    /**
     * Method to clean up the test environment after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Closing the browser
        Driver.closeDriver();
    }

    /**
     * Test case for waiting until the title changes to "Dynamic title".
     */
    @Test
    public void test_wait_until_title_change(){

        // Creating WebDriverWait object with a timeout of 15 seconds
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        // Waiting until the title is "Dynamic title"
        wait.until(ExpectedConditions.titleIs(ConfigurationReader.getProperty("expected.title.waits")));

        // Creating an instance of DynamicLoad7Page class
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        // Verifying that the "Done" message is displayed
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        // Verifying that the image is displayed
        Assert.assertTrue(dynamicLoad7Page.image.isDisplayed());
    }
}
/*
TC#10 : Dynamically Loaded Page Elements 7
1. Go to https://practice.cydeo.com/dynamic_loading/7
2. Wait until title is “Dynamic title”
3. Assert: Message “Done” is displayed.
4. Assert: Image is displayed.
Note: Follow POM
 */
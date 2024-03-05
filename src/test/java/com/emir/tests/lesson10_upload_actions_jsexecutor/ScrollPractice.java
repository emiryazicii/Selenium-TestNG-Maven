package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for scrolling functionality.
 */
public class ScrollPractice {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the practice page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));
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
     * Test case for scrolling down to "Powered by CYDEO" and then scrolling back up to "Home" link.
     */
    @Test
    public void test_scroll() {
        // Creating an Actions object
        Actions actions = new Actions(Driver.getDriver());

        // Locating the "CYDEO" link
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        // Scrolling down to "Powered by CYDEO"
        actions.moveToElement(cydeoLink).perform();

        // Scrolling up using PAGE_UP button twice to reach the "Home" link
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
    }
}
/*
TC #4: Scroll practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/
3- Scroll down to “Powered by CYDEO”
4- Scroll using Actions class “moveTo(element)” method

TC #5: Scroll practice 2
1- Continue from where the Task 4 is left in the same test.
2- Scroll back up to “Home” link using PageUP button
 */
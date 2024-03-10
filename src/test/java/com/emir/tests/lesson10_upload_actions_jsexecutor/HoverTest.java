package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for hovering over images.
 */
public class HoverTest {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the hovers page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.hovers"));
    }

    /**
     * Test case for hovering over images.
     */
    @Test
    public void testing_hover() {
        // Creating an Actions object
        Actions actions = new Actions(Driver.getDriver());

        // Hovering over the first image
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        actions.moveToElement(img1).perform();

        // Verifying if the header for the first image is displayed
        WebElement headerImg1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(headerImg1.isDisplayed());

        // Hovering over the second image
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(img2).perform();

        // Verifying if the header for the second image is displayed
        WebElement headerImg2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        Assert.assertTrue(headerImg2.isDisplayed());

        // Hovering over the third image
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(img3).perform();

        // Verifying if the header for the third image is displayed
        WebElement headerImg3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        Assert.assertTrue(headerImg3.isDisplayed());
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
TC #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
 */
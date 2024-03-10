package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates testing iframes.
 */
public class Iframe {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with an iframe
        Driver.getDriver().get(ConfigurationReader.getProperty("env.iframe"));

    }

    /**
     * Test method to test interacting with elements inside an iframe.
     */
    @Test
    public void iframe_test(){

        // Switch to the iframe by name or ID
        Driver.getDriver().switchTo().frame("mce_0_ifr");

        // Find the element inside the iframe
        WebElement textArea = Driver.getDriver().findElement(By.xpath("//p[.='Your content goes here.']"));

        // Assert that the element is displayed
        Assert.assertTrue(textArea.isDisplayed());

        // Switch back to the default content
        Driver.getDriver().switchTo().defaultContent();

        // Find a link outside the iframe
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        // Assert that the link is displayed
        Assert.assertTrue(homeLink.isDisplayed());
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

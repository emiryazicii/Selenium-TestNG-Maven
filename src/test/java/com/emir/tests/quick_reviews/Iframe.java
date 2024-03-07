package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class demonstrates testing iframes.
 */
public class Iframe {

    WebDriver driver;

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Initialize WebDriver instance
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        driver.quit();
    }

    /**
     * Test method to test interacting with elements inside an iframe.
     */
    @Test
    public void iframe_test(){
        // Navigate to the page with an iframe
        driver.get(ConfigurationReader.getProperty("env.iframe"));

        // Switch to the iframe by name or ID
        driver.switchTo().frame("mce_0_ifr");

        // Find the element inside the iframe
        WebElement textArea = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        // Assert that the element is displayed
        Assert.assertTrue(textArea.isDisplayed());

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Find a link outside the iframe
        WebElement homeLink = driver.findElement(By.linkText("Home"));

        // Assert that the link is displayed
        Assert.assertTrue(homeLink.isDisplayed());
    }
}

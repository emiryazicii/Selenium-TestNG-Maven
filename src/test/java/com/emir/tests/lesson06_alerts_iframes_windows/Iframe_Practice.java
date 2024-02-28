package com.emir.tests.lesson06_alerts_iframes_windows;

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
 * Test class to demonstrate iframe handling.
 */
public class Iframe_Practice {

    WebDriver driver;

    /**
     * Setup method to initialize WebDriver, maximize window, set implicit wait,
     * and navigate to the desired URL before each test method.
     */
    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(ConfigurationReader.getProperty("env.iframe"));
    }

    /**
     * Teardown method to quit the WebDriver instance after each test method.
     */
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    /**
     * Test case to handle an iframe.
     * <p>
     * Steps:
     * 1. Switch to the iframe with id "mce_0_ifr".
     * 2. Assert the presence of text "Your content goes here.".
     * 3. Switch back to the parent frame.
     * 4. Assert the presence of header "An iFrame containing the TinyMCE WYSIWYG Editor".
     */
    @Test
    public void testing_iframe(){

        driver.switchTo().frame("mce_0_ifr");

        WebElement text = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        Assert.assertTrue(text.isDisplayed());

        driver.switchTo().parentFrame();

        WebElement header = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assert.assertTrue(header.isDisplayed());

    }
}

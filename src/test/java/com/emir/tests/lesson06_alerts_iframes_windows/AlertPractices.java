package com.emir.tests.lesson06_alerts_iframes_windows;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class to demonstrate handling different types of alerts.
 */
public class AlertPractices {

    /**
     * Setup method to initialize WebDriver, maximize window, set implicit wait,
     * and navigate to the desired URL before each test method.
     */
    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get(ConfigurationReader.getProperty("env.alerts"));
    }

    /**
     * Test case to handle an information alert.
     * <p>
     * Steps:
     * 1. Click on the "Click for JS Alert" button.
     * 2. Accept the alert by clicking OK.
     * 3. Verify the presence of "You successfully clicked an alert" text.
     */
    @Test
    public void testing_information_alert(){

        WebElement informationAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));

        informationAlert.click();

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();

        WebElement resultText = Driver.getDriver().findElement(By.cssSelector("p#result"));

        Assert.assertTrue(resultText.isDisplayed());
    }

    /**
     * Test case to handle a confirmation alert.
     * <p>
     * Steps:
     * 1. Click on the "Click for JS Confirm" button.
     * 2. Accept the alert by clicking OK.
     * 3. Verify the presence of "You clicked: Ok" text.
     */
    @Test
    public void testing_confirmation_alert(){

        WebElement confirmationAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        confirmationAlert.click();

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.accept();

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//p[text()='You clicked: Ok']"));

        Assert.assertTrue(resultText.isDisplayed());
    }

    /**
     * Test case to handle a prompt alert.
     * <p>
     * Steps:
     * 1. Click on the "Click for JS Prompt" button.
     * 2. Send "hello" text to the alert.
     * 3. Accept the alert.
     * 4. Verify the presence of "You entered: hello" text.
     */
    @Test
    public void testing_prompt_alert(){

        WebElement promptAlert = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        promptAlert.click();

        Alert alert = Driver.getDriver().switchTo().alert();

        alert.sendKeys(ConfigurationReader.getProperty("sendKey.alert"));

        alert.accept();

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//p[.='You entered: hello']"));

        Assert.assertTrue(resultText.isDisplayed());

    }

    /**
     * Teardown method to quit the WebDriver instance after each test method.
     */
    @AfterMethod
    public void tearDown(){

       Driver.closeDriver();
    }
}

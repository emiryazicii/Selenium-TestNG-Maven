package com.emir.tests.lesson06_alerts_iframes_windows;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class to demonstrate handling different types of alerts.
 */
public class AlertPractices {

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

        driver.get(ConfigurationReader.getProperty("env.alerts"));
    }

    /**
     * Teardown method to quit the WebDriver instance after each test method.
     */
    @AfterMethod
    public void tearDown(){

        driver.quit();
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

        WebElement informationAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

        informationAlert.click();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        WebElement resultText = driver.findElement(By.cssSelector("p#result"));

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

        WebElement confirmationAlert = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));

        confirmationAlert.click();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[text()='You clicked: Ok']"));

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

        WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        promptAlert.click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys(ConfigurationReader.getProperty("sendKey.alert"));

        alert.accept();

        WebElement resultText = driver.findElement(By.xpath("//p[.='You entered: hello']"));

        Assert.assertTrue(resultText.isDisplayed());

    }
}

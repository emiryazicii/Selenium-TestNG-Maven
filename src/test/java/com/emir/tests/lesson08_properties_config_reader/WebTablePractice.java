package com.emir.tests.lesson08_properties_config_reader;

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
 * A test class for practicing web table operations.
 */
public class WebTablePractice {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the web table page.
     */
    @BeforeMethod
    public void setupMethod() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to web table page
        driver.get(ConfigurationReader.getProperty("env.webTables"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }

    /**
     * Test method to verify Bob's name and order date in the web table.
     */
    @Test
    public void testing_webTables() {
        // Find Bob's cell in the web table and verify the name
        WebElement bobCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        Assert.assertEquals(bobCell.getText(), ConfigurationReader.getProperty("customerName.tables"));

        // Find Bob Martin's order date and verify it
        WebElement orderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertEquals(orderDate.getText(), ConfigurationReader.getProperty("customer.order.date"));
    }
}
/*
TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021
 */

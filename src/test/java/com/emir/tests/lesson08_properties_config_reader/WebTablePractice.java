package com.emir.tests.lesson08_properties_config_reader;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * A test class for practicing web table operations.
 */
public class WebTablePractice {

    /**
     * Setup method to initialize the WebDriver and navigate to the web table page.
     */
    @BeforeMethod
    public void setupMethod() {

        // Navigate to web table page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.webTables"));
    }

    /**
     * Test method to verify Bob's name and order date in the web table.
     */
    @Test
    public void testing_webTables() {
        // Find Bob's cell in the web table and verify the name
        WebElement bobCell = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        Assert.assertEquals(bobCell.getText(), ConfigurationReader.getProperty("customerName.tables"));

        // Find Bob Martin's order date and verify it
        WebElement orderDate = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertEquals(orderDate.getText(), ConfigurationReader.getProperty("customer.order.date"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        Driver.closeDriver();
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

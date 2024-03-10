package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for uploading files.
 */
public class UploadTest {

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the upload page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.upload"));
    }

    /**
     * Test case for uploading a file.
     */
    @Test
    public void testing_upload() {
        // Finding and filling the choose file button with the file path
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\emirt\\Downloads\\Selenium_interview_questions (1).docx");

        // Clicking the upload button
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        // Verifying if the file uploaded header is displayed
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed());
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
TC #2 Upload Test
1. Go to https://practice.cydeo.com/upload
2. Find some small file from your computer, and get the path of it.
3. Upload the file.
4. Assert:
-File uploaded text is displayed on the page
 */
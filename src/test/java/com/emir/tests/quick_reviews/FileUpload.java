package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * This class tests the file upload functionality.
 */
public class FileUpload {

    /**
     * Test method for file upload functionality.
     */
    @Test
    public void file_upload_test(){
        // Open the upload page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.upload"));

        // Locate the choose file button and send the file path
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(ConfigurationReader.getProperty("test.data.upload"));

        // Click on the upload button
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        // Close the browser session
        Driver.closeDriver();
    }
}

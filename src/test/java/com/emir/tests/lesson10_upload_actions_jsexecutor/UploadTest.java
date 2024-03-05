package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTest {

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get(ConfigurationReader.getProperty("env.upload"));
    }

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();
    }

    @Test
    public void testing_upload(){

        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        chooseFileButton.sendKeys("C:\\Users\\emirt\\Downloads\\Selenium_interview_questions (1).docx");

        WebElement confirmationMessage = Driver.getDriver().findElement(By.xpath("//h3"));

        Assert.assertTrue(confirmationMessage.isDisplayed());

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
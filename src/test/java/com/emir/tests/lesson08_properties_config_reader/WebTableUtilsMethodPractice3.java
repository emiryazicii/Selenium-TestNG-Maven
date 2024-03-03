package com.emir.tests.lesson08_properties_config_reader;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import com.emir.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTableUtilsMethodPractice3 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(ConfigurationReader.getProperty("env.tables"));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void testing_email_cell(){

        Assert.assertEquals(WebTableUtils.getEmailFromTable(driver,"2","Jason"),ConfigurationReader.getProperty("testData.email2"));
    }
}

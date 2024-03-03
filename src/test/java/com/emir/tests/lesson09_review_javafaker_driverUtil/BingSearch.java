package com.emir.tests.lesson09_review_javafaker_driverUtil;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BingSearch {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(ConfigurationReader.getProperty("env.bing"));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void test_bing_search(){

        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='sb_form_q']"));

        searchBox.sendKeys(ConfigurationReader.getProperty("searchData.bing"));

        BrowserUtils.sleep(2);

        searchBox.sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.getTitle(),ConfigurationReader.getProperty("searchData.bing")+" - Search");

    }
}
/*
TC #1: Bing search
1- Open a chrome browser
2- Go to: https://bing.com
3- Write “apple” in search box
4- Verify title:
Expected: apple - Search
Use `configuration.properties` for the following:
1. The browser type
2. The URL
3. The search keyword
4. Make title verification dynamic. If search value changes, title
assertion should not fail.
 */
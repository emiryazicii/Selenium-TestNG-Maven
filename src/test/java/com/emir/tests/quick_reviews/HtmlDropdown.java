package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This class demonstrates testing a dropdown menu functionality in a web application.
 */
public class HtmlDropdown {

    WebDriver driver;

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Initialize WebDriver instance
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /**
     * Test method to test the HTML dropdown functionality.
     */
    @Test
    public void html_dropdown_test(){
        // Navigate to the page with dropdown menu
        driver.get(ConfigurationReader.getProperty("env.dropdown"));

        // Find the dropdown menu element
        WebElement dropdown = driver.findElement(By.id("dropdownMenuLink"));

        // Click on the dropdown menu to open it
        dropdown.click();

        // Find and click on the "Yahoo" option in the dropdown menu
        WebElement yahooLink = driver.findElement(By.linkText("Yahoo"));
        yahooLink.click();
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        driver.quit();
    }
}

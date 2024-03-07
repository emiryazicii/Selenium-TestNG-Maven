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
import java.util.Set;

/**
 * This class demonstrates window handling in Selenium WebDriver.
 */
public class WindowHandling {

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
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        driver.quit();
    }

    /**
     * Test method to demonstrate window handling.
     */
    @Test
    public void window_handling_test(){
        // Navigate to the page with a link to open a new window
        driver.get(ConfigurationReader.getProperty("env.windows"));

        // Find the link and click on it to open a new window
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        // Get all window handles
        Set<String> allWindowHandles =  driver.getWindowHandles();

        // Iterate through all window handles and switch to each window to print its title
        for (String eachWindowHandle : allWindowHandles) {
            driver.switchTo().window(eachWindowHandle);
            System.out.println("Window title: " + driver.getTitle());
        }
    }
}

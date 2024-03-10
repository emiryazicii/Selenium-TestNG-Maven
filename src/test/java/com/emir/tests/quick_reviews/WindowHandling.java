package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

/**
 * This class demonstrates window handling in Selenium WebDriver.
 */
public class WindowHandling {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with a link to open a new window
        Driver.getDriver().get(ConfigurationReader.getProperty("env.windows"));
    }

    /**
     * Test method to demonstrate window handling.
     */
    @Test
    public void window_handling_test(){

        // Find the link and click on it to open a new window
        WebElement link = Driver.getDriver().findElement(By.linkText("Click Here"));
        link.click();

        // Get all window handles
        Set<String> allWindowHandles =  Driver.getDriver().getWindowHandles();

        // Iterate through all window handles and switch to each window to print its title
        for (String eachWindowHandle : allWindowHandles) {
            Driver.getDriver().switchTo().window(eachWindowHandle);
            System.out.println("Window title: " + Driver.getDriver().getTitle());
        }
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

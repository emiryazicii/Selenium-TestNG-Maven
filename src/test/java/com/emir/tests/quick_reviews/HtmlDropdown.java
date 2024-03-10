package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates testing a dropdown menu functionality in a web application.
 */
public class HtmlDropdown {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with dropdown menu
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dropdown"));
    }

    /**
     * Test method to test the HTML dropdown functionality.
     */
    @Test
    public void html_dropdown_test(){


        // Find the dropdown menu element
        WebElement dropdown = Driver.getDriver().findElement(By.id("dropdownMenuLink"));

        // Click on the dropdown menu to open it
        dropdown.click();

        // Find and click on the "Yahoo" option in the dropdown menu
        WebElement yahooLink = Driver.getDriver().findElement(By.linkText("Yahoo"));
        yahooLink.click();
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

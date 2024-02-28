package com.emir.tests.lesson04_findElements_checkboxes_radiobuttons;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class contains a test case for handling StaleElementReferenceException.
 */
public class Stale_Element_Reference_Exception_Task {

    /**
     * This is the main method which executes the test case.
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Setting up the WebDriver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the specified URL
        driver.get(ConfigurationReader.getProperty("env.abtest"));

        // Locating the "CYDEO" link and verifying if it is displayed
        WebElement link = driver.findElement(By.xpath("//a[.='CYDEO']"));
        if(link.isDisplayed()){
            System.out.println("CYDEO link is displayed: Passed!");
        }else{
            System.out.println("CYDEO link is NOT displayed: Failed!");
        }

        // Refreshing the page
        driver.navigate().refresh();

        // Re-locating the "CYDEO" link after the page refresh and verifying if it is displayed again
        link = driver.findElement(By.xpath("//a[.='CYDEO']"));
        if(link.isDisplayed()){
            System.out.println("CYDEO link is displayed after refresh: Passed!");
        }else{
            System.out.println("CYDEO link is NOT displayed after refresh: Failed!");
        }

        // Quitting the WebDriver
        driver.quit();
    }
}
/*
TC #4: StaleElementReferenceException Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate “CYDEO” link, verify it is displayed.
4- Refresh the page.
5- Verify it is displayed, again.
This is a simple StaleElementReferenceException to understand what is
this exception and how to handle it.
 */

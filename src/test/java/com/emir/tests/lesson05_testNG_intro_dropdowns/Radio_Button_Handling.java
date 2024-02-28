package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class contains a test case for handling radio buttons.
 */
public class Radio_Button_Handling {

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
        driver.get(ConfigurationReader.getProperty("env.radio_buttons"));

        // Locating and clicking the "Hockey" radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();

        // Verifying if the "Hockey" radio button is selected after clicking
        if(hockeyButton.isSelected()){
            System.out.println("Hockey radio button is selected after clicking: Passed!");
        }else {
            System.out.println("Hockey radio button is NOT selected after clicking: Failed!");
        }

        // Quitting the WebDriver
        driver.quit();
    }
}
/*
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */

package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class contains a test case for handling radio buttons.
 */
public class Radio_Button_Handling {

    public static void main(String[] args) {

        // Opening the specified URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.radio_buttons"));

        // Locating and clicking the "Hockey" radio button
        WebElement hockeyButton = Driver.getDriver().findElement(By.xpath("//input[@id='hockey']"));
        hockeyButton.click();

        // Verifying if the "Hockey" radio button is selected after clicking
        if(hockeyButton.isSelected()){
            System.out.println("Hockey radio button is selected after clicking: Passed!");
        }else {
            System.out.println("Hockey radio button is NOT selected after clicking: Failed!");
        }

        // Quitting the WebDriver
        Driver.closeDriver();
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

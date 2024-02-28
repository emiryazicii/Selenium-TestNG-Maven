package com.emir.tests.lesson04_findElements_checkboxes_radiobuttons;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class contains a test case for checking checkboxes.
 */
public class Checkboxes {

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
        driver.get(ConfigurationReader.getProperty("env.checkboxes"));

        // Locating the first checkbox and verifying if it is not selected by default
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#box1"));
        if(!checkbox1.isSelected()){
            System.out.println("Checkbox #1 is NOT selected by default: Passed!");
        }else {
            System.out.println("Checkbox #1 is SELECTED by default: Failed!");
        }

        // Locating the second checkbox and verifying if it is selected by default
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        if(checkbox2.isSelected()){
            System.out.println("Checkbox #2 is SELECTED by default: Passed!");
        }else{
            System.out.println("Checkbox #2 is NOT selected by default: Failed!");
        }

        // Clicking checkbox #1 to select it
        checkbox1.click();

        // Clicking checkbox #2 to deselect it
        checkbox2.click();

        // Verifying if checkbox #1 is selected after clicking
        if(checkbox1.isSelected()){
            System.out.println("Checkbox #1 is SELECTED: Passed!");
        }else{
            System.out.println("Checkbox #1 is NOT selected: Failed!");
        }

        // Verifying if checkbox #2 is not selected after clicking
        if (!checkbox2.isSelected()){
            System.out.println("Checkbox #2 is NOT selected: Passed!");
        }else {
            System.out.println("Checkbox #2 is SELECTED: Failed!");
        }

        // Quitting the WebDriver
        driver.quit();
    }
}
/*
TC#3: Checkboxes
1. Go to https://practice.cydeo.com/checkboxes
2. Confirm checkbox #1 is NOT selected by default
3. Confirm checkbox #2 is SELECTED by default.
4. Click checkbox #1 to select it.
5. Click checkbox #2 to deselect it.
6. Confirm checkbox #1 is SELECTED.
7. Confirm checkbox #2 is NOT selected.
 */

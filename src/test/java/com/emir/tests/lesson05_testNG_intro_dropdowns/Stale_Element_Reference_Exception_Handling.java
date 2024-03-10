package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

/**
 * This class contains a test case for handling StaleElementReferenceException.
 */
public class Stale_Element_Reference_Exception_Handling {

    public static void main(String[] args) {

        // Opening the specified URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.add_remove_elements"));

        // Locating and clicking the "Add Element" button
        WebElement addElementButton = Driver.getDriver().findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        // Locating the "Delete" button and verifying if it is displayed
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed after adding element: Passed!");
        }else{
            System.out.println("Delete button is NOT displayed after adding element: Failed!");
        }

        // Clicking the "Delete" button
        deleteButton.click();

        // Handling StaleElementReferenceException by re-locating the "Delete" button and verifying if it is NOT displayed
        try{
            if (!deleteButton.isDisplayed()){
                System.out.println("Delete button is NOT displayed after clicking: Passed!");
            }else{
                System.out.println("Delete button is displayed after clicking: Failed!");
            }
        }catch (StaleElementReferenceException e){
            System.out.println("--> StaleElementReferenceException occurred: element has been deleted from the page.");
            System.out.println("Test case PASSED as expected!");
            System.out.println("!deleteButton.isDisplayed()= true ");
        }

        // Quitting the WebDriver
        Driver.closeDriver();
    }
}
/*
TC #1: StaleElementReferenceException handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
 */

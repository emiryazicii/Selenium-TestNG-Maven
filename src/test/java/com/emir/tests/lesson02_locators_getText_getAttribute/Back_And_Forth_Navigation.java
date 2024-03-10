package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class demonstrates back and forth navigation using Selenium WebDriver.
 */
public class Back_And_Forth_Navigation {

    public static void main(String[] args) {

        // Navigate to the Cydeo Practice Tool website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find and click the link with partial text "A/B"
        WebElement link = Driver.getDriver().findElement(By.partialLinkText("A/B"));
        link.click();

        // Get the current title after clicking the link
        String currentTitle = Driver.getDriver().getTitle();

        // Verify if title equals "No A/B Test" and print the result
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.practice"))){
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed");
        }

        // Navigate back to the previous page
        Driver.getDriver().navigate().back();

        // Get the current title after navigating back
        currentTitle = Driver.getDriver().getTitle();

        // Verify if title equals "Practice" and print the result
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.title"))){
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed");
        }

        // Quit the WebDriver session
       Driver.closeDriver();
    }
}
/*
TC #2: Back and forth navigation
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */

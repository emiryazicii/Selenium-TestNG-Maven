package com.emir.tests.lesson02_locators_getText_getAttribute;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;

/**
 * This class verifies the URL and title of the Cydeo Practice Tool.
 */
public class Cydeo_Practice_Tool_Verification {

    public static void main(String[] args) {

        // Navigate to the Cydeo Practice Tool website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Get the current URL
        String currentURL = Driver.getDriver().getCurrentUrl();

        // Verify if URL contains "cydeo" and print the result
        if(currentURL.contains(ConfigurationReader.getProperty("expectedData.cydeo2"))){
            System.out.println("URL Verification Passed!");
        } else {
            System.out.println("URL Verification Failed");
        }

        // Get the current title
        String currentTitle = Driver.getDriver().getTitle();

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
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
 Expected: Practice
 */

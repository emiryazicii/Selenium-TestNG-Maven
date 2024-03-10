package com.emir.tests.lesson03_cssSelector_XPATH.extraPractices;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class verifies the back and forth navigation between Google and Gmail.
 */
public class Back_And_Forth_Navigation {

    public static void main(String[] args) {

        // Navigate to the Google website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.google"));

        //WebElement link = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/&ogbl']"));

        //WebElement link = driver.findElement(By.xpath("//a[text()='Gmail']"));

        // Find the Gmail link by CSS selector and click on it
        WebElement link = Driver.getDriver().findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));
        link.click();

        // Verify if the title contains "Gmail"
        String currentTitle = Driver.getDriver().getTitle();
        if(currentTitle.contains(ConfigurationReader.getProperty("expectedData.google"))){
            System.out.println("Title Contains 'Gmail' Verification Passed!");
        } else {
            System.out.println("Title Contains 'Gmail' Verification Failed!");
        }

        // Navigate back to Google using the browser's back function
        Driver.getDriver().navigate().back();

        // Verify if the title equals "Google" after navigating back
        currentTitle = Driver.getDriver().getTitle();
        if(currentTitle.equals(ConfigurationReader.getProperty("expectedData.google2"))){
            System.out.println("Title Equals 'Google' Verification Passed!");
        } else {
            System.out.println("Title Equals 'Google' Verification Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}
/*
TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
 */

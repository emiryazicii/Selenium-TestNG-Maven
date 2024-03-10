package com.emir.tests.lesson03_cssSelector_XPATH.extraPractices;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class verifies the title of the Practice Cydeo website after clicking on the "Home" link.
 */
public class PracticeCydeo_Xpath_Locator_Practice {

    public static void main(String[] args) {

        // Navigate to the Practice Cydeo website
        Driver.getDriver().get(ConfigurationReader.getProperty("env.inputs"));

        //WebElement link = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //WebElement link = driver.findElement(By.xpath("//a[text()='Home']"));

        //WebElement link = driver.findElement(By.linkText("Home"));

        // Find the "Home" link element by CSS selector and click on it
        WebElement link = Driver.getDriver().findElement(By.cssSelector("a.nav-link"));
        link.click();

        // Get the current title of the webpage after clicking on the "Home" link
        String currentTitle = Driver.getDriver().getTitle();

        // Verify if the title matches the expected title
        if (currentTitle.equals(ConfigurationReader.getProperty("expectedData.title"))) {
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}
/*
HWP #4: Practice Cydeo – xpath locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “xpath” locator
 */

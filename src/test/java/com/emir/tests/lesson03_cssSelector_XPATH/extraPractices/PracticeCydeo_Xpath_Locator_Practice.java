package com.emir.tests.lesson03_cssSelector_XPATH.extraPractices;

import com.emir.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class verifies the title of the Practice Cydeo website after clicking on the "Home" link.
 */
public class PracticeCydeo_Xpath_Locator_Practice {

    /**
     * The main method to execute the verification of the Practice Cydeo website title.
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {

        // Create a ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the window for better visibility
        driver.manage().window().maximize();

        // Navigate to the Practice Cydeo website
        driver.get(ConfigurationReader.getProperty("env.inputs"));

        //WebElement link = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //WebElement link = driver.findElement(By.xpath("//a[text()='Home']"));

        //WebElement link = driver.findElement(By.linkText("Home"));

        // Find the "Home" link element by CSS selector and click on it
        WebElement link = driver.findElement(By.cssSelector("a.nav-link"));
        link.click();

        // Get the current title of the webpage after clicking on the "Home" link
        String currentTitle = driver.getTitle();

        // Verify if the title matches the expected title
        if (currentTitle.equals(ConfigurationReader.getProperty("expectedData.title"))) {
            System.out.println("Title Verification Passed!");
        } else {
            System.out.println("Title Verification Failed!");
        }

        // Quit the WebDriver session
        driver.quit();
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

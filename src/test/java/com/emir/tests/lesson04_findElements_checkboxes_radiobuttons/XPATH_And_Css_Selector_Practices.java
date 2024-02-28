package com.emir.tests.lesson04_findElements_checkboxes_radiobuttons;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * This class contains test cases for practicing XPath and CSS Selector locators.
 */
public class XPATH_And_Css_Selector_Practices {

    /**
     * This is the main method which executes the test cases.
     * @param args Unused.
     */
    public static void main(String[] args) {

        // Setting up the WebDriver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Opening the specified URL
        driver.get(ConfigurationReader.getProperty("env.forgot_password"));

        //WebElement link = driver.findElement(By.xpath("//a[@class='nav-link']"));
        //WebElement link = driver.findElement(By.xpath("//a[text()='Home']"));
        //WebElement link = driver.findElement(By.xpath("//*[.='Home']"));
        //WebElement link = driver.findElement(By.xpath("//a[@href='/']"));
        //WebElement link = driver.findElement(By.cssSelector("a.nav-link"));
        //WebElement link = driver.findElement(By.cssSelector("a[class='nav-link']"));

        // Locating "Home" link using CSS selector
        WebElement link = driver.findElement(By.cssSelector("a[href='/']"));
        if (link.isDisplayed()){
            System.out.println("Passed for 'Home' link using CSS selector!");
        } else {
            System.out.println("Failed for 'Home' link using CSS selector!");
        }

        //WebElement header = driver.findElement(By.xpath("//h2"));
        //WebElement header = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        //WebElement header = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        //WebElement header = driver.findElement(By.cssSelector("div[class='example']>h2"));

        // Locating "Forgot password" header using CSS selector
        WebElement header = driver.findElement(By.cssSelector("div.example>h2"));
        if (header.isDisplayed()){
            System.out.println("Passed for 'Forgot password' header using CSS selector!");
        } else {
            System.out.println("Failed for 'Forgot password' header using CSS selector!");
        }

        //WebElement text = driver.findElement(By.xpath("//label[@for='email']"));
        //WebElement text = driver.findElement(By.xpath("//label[.='E-mail']"));
        //WebElement text = driver.findElement(By.xpath("//label[text()='E-mail']"));

        // Locating "E-mail" text using CSS selector
        WebElement text = driver.findElement(By.cssSelector("label[for='email']"));
        if(text.isDisplayed()){
            System.out.println("Passed for 'E-mail' text using CSS selector!");
        } else {
            System.out.println("Failed for 'E-mail' text using CSS selector!");
        }

        //WebElement box = driver.findElement(By.xpath("//input[@name='email']"));
        //WebElement box = driver.findElement(By.xpath("//input[@type='text']"));

        // Locating E-mail input box using XPath
        WebElement box = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));
        if (box.isDisplayed()){
            System.out.println("Passed for E-mail input box using XPath!");
        } else {
            System.out.println("Failed for E-mail input box using XPath!");
        }

        //WebElement button = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        //WebElement button = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        //WebElement button = driver.findElement(By.xpath("//*[text()='Retrieve password']"));
        //WebElement button = driver.findElement(By.cssSelector("button#form_submit>i"));

        // Locating "Retrieve password" button using XPath
        WebElement button = driver.findElement(By.cssSelector("button.radius>i"));
        if (button.isDisplayed()){
            System.out.println("Passed for 'Retrieve password' button using CSS selector!");
        } else {
            System.out.println("Failed for 'Retrieve password' button using CSS selector!");
        }

        //WebElement cydeo = driver.findElement(By.xpath("//a[@target='_blank']"));
        //WebElement cydeo = driver.findElement(By.xpath("//a[.='CYDEO']"));
        //WebElement cydeo = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));

        // Locating "Powered by Cydeo" text using XPath
        WebElement cydeo = driver.findElement(By.cssSelector("div[style='text-align: center;']>a"));
        if(cydeo.isDisplayed()){
            System.out.println("Passed for 'Powered by Cydeo' text using CSS selector!");
        } else {
            System.out.println("Failed for 'Powered by Cydeo' text using CSS selector!");
        }

        // Quitting the WebDriver
        driver.quit();
    }
}
/*
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible
Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible
 */

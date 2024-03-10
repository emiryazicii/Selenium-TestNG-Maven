package com.emir.tests.lesson04_findElements_checkboxes_radiobuttons;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * This class contains a test case for locating and printing information about links on a webpage.
 */
public class Find_Elements_Task {

    public static void main(String[] args) {

        // Opening the specified URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.abtest"));

        // Locating all the links on the page using tagName
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));

        // Printing out the number of links on the page
        System.out.println("Number of the links = " + allLinks.size());

        // Iterating through each link to print its text and href attribute value
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }

        // Quitting the WebDriver
        Driver.closeDriver();
    }
}
/*
TC #2: FindElements Task
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/abtest
3- Locate all the links in the page.
4- Print out the number of the links on the page.
5- Print out the texts of the links.
6- Print out the HREF attribute values of the links
 */

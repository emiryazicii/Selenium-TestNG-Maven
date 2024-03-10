package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * This class demonstrates finding all elements of a specific type on a webpage and printing their URLs and text.
 */
public class FindElements {

     //Retrieves all links on a webpage and prints their URLs and text.
    public static void main(String[] args) {

        // Navigate to the practice environment webpage
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find all the links on the page by tag name
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));

        // Print the number of links found on the page
        System.out.println(allLinks.size() + " links on the page.");

        // Iterate through each link and print its URL and text
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getAttribute("href"));
            System.out.println(eachLink.getText());
        }

        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

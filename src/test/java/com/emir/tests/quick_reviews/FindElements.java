package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FindElements {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();

        driver.get(ConfigurationReader.getProperty("env.practice"));

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size()+" links on the page.");

        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getAttribute("href"));
            System.out.println(eachLink.getText());
        }

        driver.quit();
    }
}

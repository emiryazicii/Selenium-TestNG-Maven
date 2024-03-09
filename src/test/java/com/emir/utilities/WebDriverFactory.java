package com.emir.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class provides a factory method to create WebDriver instances based on the specified browser type.
 */
public class WebDriverFactory {

    /**
     * This method creates and returns a WebDriver instance based on the specified browser type.
     * @param browserType A String representing the type of browser to be launched (e.g., "chrome", "firefox", "edge").
     * @return A WebDriver instance corresponding to the specified browser type.
     *         If the browser type is not recognized or supported, it returns null.
     */
    public static WebDriver getDriver(String browserType){

        switch (browserType.toLowerCase()){
            case"chrome":
                return new ChromeDriver();
            case"edge":
                return new EdgeDriver();
            case"firefox":
                return new FirefoxDriver();
            default:
                System.out.println("Given string doesn't represent any browser.");
                System.out.println("Either that browser does not exist or not currently supported.");
                System.out.println("driver = null");
                return null;
        }
    }
}
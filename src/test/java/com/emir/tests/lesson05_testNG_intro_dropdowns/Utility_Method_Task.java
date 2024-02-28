package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

/**
 * This class contains a utility method to handle radio buttons.
 */
public class Utility_Method_Task {

    /**
     * This is the main method which executes the test case.
     * @param args Unused.
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(ConfigurationReader.getProperty("env.radio_buttons"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton(driver, "sport", "hockey"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton(driver, "sport", "football"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton(driver, "color", "red"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton(driver, "color", "green"));

        driver.quit();

    }

    /**
     * This method clicks on the specified radio button and verifies if it is selected.
     * @param driver The WebDriver instance.
     * @param nameAttribute The name attribute of the radio button group.
     * @param expectedID The ID attribute of the radio button to be clicked.
     * @return True if the radio button is selected after clicking, false otherwise.
     */
    public static boolean clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String expectedID){

        // Find all radio buttons with the specified name attribute
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));

        // Iterate through the radio buttons
        for (WebElement eachButton : radioButtons) {
            String actualID = eachButton.getAttribute("id");

            // If the ID matches the expected ID, click the button and break the loop
            if (actualID.equals(expectedID)){
                eachButton.click();
                break;
            }
        }

        // Verify if the radio button is selected after clicking
        for (WebElement button : radioButtons) {
            if (button.getAttribute("id").equals(expectedID)) {
                return button.isSelected();
            }
        }

        // Return false if the radio button is not found or not selected after clicking
        return false;
    }
}
/*
TC #3: Utility method task for (continuation of Task2)
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)
Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true
 */

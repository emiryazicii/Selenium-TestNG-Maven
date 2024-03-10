package com.emir.tests.lesson05_testNG_intro_dropdowns;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * This class contains a utility method to handle radio buttons.
 */
public class Utility_Method_Task {

    public static void main(String[] args) {

        Driver.getDriver().get(ConfigurationReader.getProperty("env.radio_buttons"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton( "sport", "hockey"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton( "sport", "football"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton( "color", "red"));

        System.out.println("Is Button selected = " + clickAndVerifyRadioButton( "color", "green"));

        Driver.closeDriver();
    }

    /**
     * This method clicks on the specified radio button and verifies if it is selected.
     * @param nameAttribute The name attribute of the radio button group.
     * @param expectedID The ID attribute of the radio button to be clicked.
     * @return True if the radio button is selected after clicking, false otherwise.
     */
    public static boolean clickAndVerifyRadioButton(String nameAttribute, String expectedID){

        // Find all radio buttons with the specified name attribute
        List<WebElement> radioButtons = Driver.getDriver().findElements(By.name(nameAttribute));

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

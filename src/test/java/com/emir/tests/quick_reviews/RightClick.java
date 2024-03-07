package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * This class tests the right-click functionality.
 */
public class RightClick {

    /**
     * Test method for right-click functionality.
     */
    @Test
    public void right_click_test(){
        // Open the practice page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.practice"));

        // Find the A/B Testing link
        WebElement abTestLink = Driver.getDriver().findElement(By.linkText("A/B Testing"));

        // Create Actions object
        Actions actions = new Actions(Driver.getDriver());

        // Perform right-click on the A/B Testing link, followed by arrow down key press and return key press
        actions.contextClick(abTestLink)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.RETURN)
                .perform();

        // Close the browser session
        Driver.closeDriver();
    }
}

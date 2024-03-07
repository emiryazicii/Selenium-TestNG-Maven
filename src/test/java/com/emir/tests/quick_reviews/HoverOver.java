package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * This class tests the hover-over functionality.
 */
public class HoverOver {

    /**
     * Test method for hover-over functionality.
     */
    @Test
    public void hover_over_test(){
        // Open the hovers page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.hovers"));

        // Find the images
        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        // Create Actions object
        Actions actions = new Actions(Driver.getDriver());

        // Perform hover-over actions on the images with pauses in between
        actions.moveToElement(image1).pause(1000)
                .moveToElement(image2).pause(1000)
                .moveToElement(image3).pause(1000)
                .perform();

        // Close the browser session
        Driver.closeDriver();
    }
}

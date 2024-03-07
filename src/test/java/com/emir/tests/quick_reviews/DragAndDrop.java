package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * This class tests the drag and drop functionality.
 */
public class DragAndDrop {

    /**
     * Test method for drag and drop functionality.
     */
    @Test
    public void drag_and_drop_test(){
        // Open the drag and drop page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dragAndDrop"));

        // Find the small circle element to drag
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        // Find the big circle element to drop onto
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        // Create Actions object
        Actions actions = new Actions(Driver.getDriver());

        // Perform drag and drop action from small circle to big circle with a pause
        actions.dragAndDrop(smallCircle, bigCircle).pause(1000).perform();

        // Close the browser session
        Driver.closeDriver();
    }
}

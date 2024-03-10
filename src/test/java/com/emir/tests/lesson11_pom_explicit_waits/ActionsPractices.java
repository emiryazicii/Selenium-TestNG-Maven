package com.emir.tests.lesson11_pom_explicit_waits;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for practicing actions using Actions class.
 */
public class ActionsPractices {

    // Instance variable to hold the Actions object
    Actions actions;

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Opening the drag and drop circles page URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.dragAndDrop"));

        // Initializing the Actions object
        actions = new Actions(Driver.getDriver());
    }

    /**
     * Test case for verifying the default text in the big circle.
     */
    @Test
    public void test_default_text(){
        // Locating the big circle element
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        // Verifying the default text in the big circle
        Assert.assertEquals(bigCircle.getText(), ConfigurationReader.getProperty("expected.text"));
    }

    /**
     * Test case for dragging and dropping the small circle into the big circle.
     */
    @Test
    public void test_text_after_drag_and_drop(){

        // Locating the big circle and small circle elements
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        // Performing the drag and drop action
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();

        // Verifying the text in the big circle after drag and drop
        Assert.assertEquals(bigCircle.getText(), ConfigurationReader.getProperty("expected.text2"));
    }

    /**
     * Test case for clicking and holding the small circle.
     */
    @Test
    public void test_text_after_click_and_hold(){

        // Locating the big circle and small circle elements
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        // Performing the click and hold action
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO")))
                .perform();

        // Verifying the text in the big circle after click and hold
        Assert.assertEquals(bigCircle.getText(), ConfigurationReader.getProperty("expected.text3"));
    }

    /**
     * Test case for dragging and dropping the small circle outside of the big circle.
     */
    @Test
    public void test_text_after_drag_and_drop_outside_of_the_big_circle(){

        // Locating the big circle and small circle elements
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        // Performing the drag and drop outside of the big circle
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(Driver.getDriver().findElement(By.linkText("CYDEO")))
                .release()
                .perform();

        // Verifying the text in the big circle after drag and drop outside of the big circle
        Assert.assertEquals(bigCircle.getText(), ConfigurationReader.getProperty("expected.text4"));
    }

    /**
     * Test case for dragging and holding the small circle inside of the big circle.
     */
    @Test
    public void test_text_after_drag_and_hold_inside_of_the_big_circle(){

        // Locating the big circle and small circle elements
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));

        // Performing the drag and hold inside of the big circle
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .perform();

        // Verifying the text in the big circle after drag and hold inside of the big circle
        Assert.assertEquals(bigCircle.getText(), ConfigurationReader.getProperty("expected.text5"));
    }

    /**
     * Method to clean up the test environment after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Closing the browser
        Driver.closeDriver();
    }
}
/*
TC2 #: Drag and drop default value verification
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Verify big circle default text is as below.
3. Assert:
-Text in big circle changed to: “Drag the small circle here.”


TC3 #: Drag and drop into the big circle
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “You did great!”


TC4 #: Click and hold
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Click and hold the small circle.
3. Assert:
-Text in big circle changed to: “Drop here.”


TC5 #: Drag and drop outside of the big circle
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag and drop the small circle to bigger circle.
3. Assert:
-Text in big circle changed to: “Try again!”


TC6 #: Drag and hover
1. Go to https://practice.cydeo.com/drag_and_drop_circles
2. Drag the small circle on top of the big circle, hold it, and verify.
3. Assert:
-Text in big circle changed to: “Now drop…”
 */
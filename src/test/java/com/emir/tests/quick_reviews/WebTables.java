package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

/**
 * This class demonstrates interacting with web tables in Selenium WebDriver.
 */
public class WebTables {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Navigate to the page with a web table
        Driver.getDriver().get(ConfigurationReader.getProperty("env.tables"));
    }

    /**
     * Test method to interact with a web table.
     */
    @Test
    public void webTable_test(){


        // Find the cell containing "John" in the web table
        WebElement johnCell = Driver.getDriver().findElement(By.xpath("//table[@id='table1']//td[.='John']"));

        // Assert that the text in the cell matches the expected text
        Assert.assertEquals(johnCell.getText(), ConfigurationReader.getProperty("expected.text.tables"));

        // Find all cells in the third row of the web table
        List<WebElement> johnRow = Driver.getDriver().findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));

        // Print the text of each cell in the third row
        for (WebElement eachCell : johnRow) {
            System.out.println(eachCell.getText());
        }
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        Driver.closeDriver();
    }
}

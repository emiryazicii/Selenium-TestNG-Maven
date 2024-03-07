package com.emir.tests.quick_reviews;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

/**
 * This class demonstrates interacting with web tables in Selenium WebDriver.
 */
public class WebTables {

    WebDriver driver;

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        // Initialize WebDriver instance
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the implicit wait timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        driver.quit();
    }

    /**
     * Test method to interact with a web table.
     */
    @Test
    public void webTable_test(){
        // Navigate to the page with a web table
        driver.get(ConfigurationReader.getProperty("env.tables"));

        // Find the cell containing "John" in the web table
        WebElement johnCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']"));

        // Assert that the text in the cell matches the expected text
        Assert.assertEquals(johnCell.getText(), ConfigurationReader.getProperty("expected.text.tables"));

        // Find all cells in the third row of the web table
        List<WebElement> johnRow = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));

        // Print the text of each cell in the third row
        for (WebElement eachCell : johnRow) {
            System.out.println(eachCell.getText());
        }
    }
}

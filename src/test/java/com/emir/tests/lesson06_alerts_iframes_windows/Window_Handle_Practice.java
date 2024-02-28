package com.emir.tests.lesson06_alerts_iframes_windows;

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
import java.util.Set;

/**
 * Test class to demonstrate window handling.
 */
public class Window_Handle_Practice {

    WebDriver driver;

    /**
     * Setup method to initialize WebDriver, maximize window, set implicit wait,
     * and navigate to the desired URL before each test method.
     */
    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(ConfigurationReader.getProperty("env.windows"));
    }

    /**
     * Teardown method to quit the WebDriver instance after each test method.
     */
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    /**
     * Test case to handle window switching.
     * <p>
     * Steps:
     * 1. Get the current window title.
     * 2. Assert that the current title matches the expected title.
     * 3. Get the main window handle.
     * 4. Click on the "Click Here" link.
     * 5. Get all window handles.
     * 6. Remove the main window handle from the set of handles.
     * 7. Switch to the new window.
     * 8. Assert that the title of the new window matches the expected title.
     * 9. Switch back to the main window.
     */
    @Test
    public void testing_windows(){

        String currentTitle = driver.getTitle();

        Assert.assertEquals(currentTitle, ConfigurationReader.getProperty("expected.data.windows"));

        String mainHandle = driver.getWindowHandle();

        WebElement link = driver.findElement(By.xpath("//a[.='Click Here']"));

        link.click();

        Set<String> allHandles = driver.getWindowHandles();

        allHandles.remove(mainHandle);

        for (String each : allHandles) {
            driver.switchTo().window(each);
        }

        currentTitle = driver.getTitle();

        Assert.assertEquals(currentTitle, ConfigurationReader.getProperty("expected.data.windows2"));

        driver.switchTo().window(mainHandle);
    }
}

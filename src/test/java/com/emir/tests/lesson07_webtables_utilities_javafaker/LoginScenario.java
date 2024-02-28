package com.emir.tests.lesson07_webtables_utilities_javafaker;

import com.emir.utilities.BrowserUtils;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Crm_Login;
import com.emir.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * A test class for testing the login scenario on a CRM website.
 */
public class LoginScenario {

    WebDriver driver;

    /**
     * Setup method to initialize the WebDriver and navigate to the CRM website.
     */
    @BeforeMethod
    public void setupMethod() {
        // Initialize WebDriver
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));

        // Maximize window
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to CRM website
        driver.get(ConfigurationReader.getProperty("env.crm"));
    }

    /**
     * Teardown method to quit the WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        // Quit WebDriver
        driver.quit();
    }

    /**
     * Test method to perform login and verify the title of the CRM portal.
     */
    @Test
    public void test_login() {
        // Find username input box and enter valid username
        WebElement usernameBox = driver.findElement(By.xpath("//input[@placeholder='Username or Email']"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username.login"));

        // Find password input box and enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password.login"));

        // Find login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        // Assert that the title of the page is as expected (Portal)
        Assert.assertTrue(BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("expected.title.crm")));
    }

    /**
     * Test case to perform CRM login using default credentials.
     */
    @Test
    public void test_login2() {
        // Perform CRM login using default credentials
        Crm_Login.login_crm(driver);

        // Wait for 3 seconds
        BrowserUtils.sleep(3);

        // Assert that the title of the page is as expected
        Assert.assertTrue(BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("expected.title.crm")));
    }

    /**
     * Test case to perform CRM login using custom credentials.
     */
    @Test
    public void testing_login3() {
        // Perform CRM login using custom credentials
        Crm_Login.login_crm(driver, ConfigurationReader.getProperty("username.login"), ConfigurationReader.getProperty("password.login"));

        // Wait for 3 seconds
        BrowserUtils.sleep(3);

        // Assert that the title of the page is as expected
        Assert.assertTrue(BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("expected.title.crm")));
    }


}
/*
TC #4: Login scenario
1. Create new test and make set ups
2. Go to: http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal
USERNAME PASSWORD
helpdesk1@cydeo.com UserUser
helpdesk2@cydeo.com UserUser
 */

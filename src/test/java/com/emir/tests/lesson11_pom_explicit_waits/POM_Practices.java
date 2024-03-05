package com.emir.tests.lesson11_pom_explicit_waits;

import com.emir.pages.LibraryLoginPage;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Library Login page tests using the Page Object Model (POM) design pattern.
 */
public class POM_Practices {

    // Instance variable to hold the LibraryLoginPage object
    LibraryLoginPage libraryLoginPage;

    /**
     * Method to set up the test environment before each test method.
     * Opens the browser and navigates to the Library login page.
     */
    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env.library"));
        libraryLoginPage = new LibraryLoginPage();
    }

    /**
     * Method to clean up the test environment after each test method.
     * Closes the browser.
     */
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    /**
     * Test case for verifying the presence of the required field error message.
     */
    @Test
    public void test_required_field_error_message() {
        // Click on the Sign In button without entering any information
        libraryLoginPage.btnSignIn.click();
        // Verify if the required field error message is displayed
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
    }

    /**
     * Test case for verifying the presence of the invalid email format error message.
     */
    @Test
    public void test_invalid_email_format_error_message() {
        // Enter an invalid email format
        libraryLoginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("invalid.email.format"));
        // Click on the Sign In button
        libraryLoginPage.btnSignIn.click();
        // Verify if the invalid email format error message is displayed
        Assert.assertTrue(libraryLoginPage.invalidEmailErrorMessage.isDisplayed());
    }

    /**
     * Test case for verifying the presence of the wrong email or password error message.
     */
    @Test
    public void test_wrong_email_or_password_error_message() {
        // Enter an incorrect username
        libraryLoginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("wrong.email"));
        // Enter an incorrect password
        libraryLoginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("test.password"));
        // Click on the Sign In button
        libraryLoginPage.btnSignIn.click();
        // Verify if the wrong email or password error message is displayed
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordMessage.isDisplayed());
    }
}
/*
TC #7: Required field error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.
NOTE: FOLLOW POM DESIGN PATTERN


TC #8: Invalid email format error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter invalid email format
4- Verify expected error is displayed:
Expected: Please enter a valid email address.
NOTE: FOLLOW POM DESIGN PATTERN


TC #9: Library negative login
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Enter incorrect username or incorrect password
4- Verify title expected error is displayed:
Expected: Sorry, Wrong Email or Password
NOTE: FOLLOW POM DESIGN PATTERN
 */
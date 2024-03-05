package com.emir.tests.lesson10_upload_actions_jsexecutor;

import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for registration form functionality.
 */
public class RegistrationForm {

    // Initializing Faker object for generating random data
    Faker faker = new Faker();

    /**
     * Method to set up the test environment before each test method.
     */
    @BeforeMethod
    public void setupMethod() {
        // Opening the registration form URL
        Driver.getDriver().get(ConfigurationReader.getProperty("env.registration"));
    }

    /**
     * Method to clean up the test environment after each test method.
     */
    @AfterMethod
    public void tearDown() {
        // Closing the browser
        Driver.closeDriver();
    }

    /**
     * Test case for testing registration form submission.
     */
    @Test
    public void testing_registration_form() {
        // Finding and filling the first name field with a random first name
        WebElement firstNameBox = Driver.getDriver().findElement(By.name("firstname"));
        firstNameBox.sendKeys(faker.name().firstName());

        // Finding and filling the last name field with a random last name
        WebElement lastNameBox = Driver.getDriver().findElement(By.name("lastname"));
        lastNameBox.sendKeys(faker.name().lastName());

        // Finding and filling the username field
        WebElement usernameBox = Driver.getDriver().findElement(By.name("username"));
        usernameBox.sendKeys("doubletrouble");

        // Finding and filling the email field with a randomly generated email
        WebElement emailBox = Driver.getDriver().findElement(By.name("email"));
        emailBox.sendKeys(faker.name().firstName().toLowerCase() + "123@hotmail.com");

        // Finding and filling the password field with a randomly generated password
        WebElement passwordBox = Driver.getDriver().findElement(By.name("password"));
        passwordBox.sendKeys(faker.bothify("??###?#?###"));

        // Finding and filling the phone number field with a randomly generated phone number
        WebElement phoneNumberBox = Driver.getDriver().findElement(By.name("phone"));
        phoneNumberBox.sendKeys(faker.numerify("###-###-####"));

        // Selecting the gender radio button
        WebElement maleRadioBox = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        maleRadioBox.click();

        // Finding and filling the birthday field
        WebElement birthdayBox = Driver.getDriver().findElement(By.name("birthday"));
        birthdayBox.sendKeys("07/12/1985");

        // Selecting the department from the dropdown
        Select department = new Select(Driver.getDriver().findElement(By.name("department")));
        department.selectByVisibleText("Department of Engineering");

        // Selecting the job title from the dropdown
        Select jobTitle = new Select(Driver.getDriver().findElement(By.name("job_title")));
        jobTitle.selectByIndex(4);

        // Checking the programming language checkbox
        WebElement progLang = Driver.getDriver().findElement(By.id("inlineCheckbox2"));
        progLang.click();

        // Clicking the sign up button
        WebElement signUpButton = Driver.getDriver().findElement(By.id("wooden_spoon"));
        signUpButton.click();

        // Verifying the success message after registration
        WebElement confirmMessage = Driver.getDriver().findElement(By.xpath("//p"));
        Assert.assertTrue(confirmMessage.isDisplayed());
    }
}
/*
TC#1: Registration form confirmation
1. Open browser
2. Go to website: https://practice.cydeo.com/registration_form
3. Enter first name
4. Enter last name
5. Enter username
6. Enter email address
7. Enter password
8. Enter phone number
9. Select a gender from radio buttons
10.Enter date of birth
11.Select Department/Office
12.Select Job Title
13.Select programming language from checkboxes
14.Click to sign up button
15.Verify success message “You’ve successfully completed registration.” is
displayed.
 */
package com.emir.tests.quick_reviews;

import com.emir.pages.PracticeLoginPage;
import com.emir.utilities.ConfigurationReader;
import com.emir.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModel {

    @Test
    public void login_page_test(){

        // Instantiate the PracticeLoginPage class
        PracticeLoginPage practiceLoginPage = new PracticeLoginPage();

        // Navigate to the login page
        Driver.getDriver().get(ConfigurationReader.getProperty("env.login"));

        // Enter the username retrieved from the configuration file
        practiceLoginPage.username.sendKeys(ConfigurationReader.getProperty("username.login2"));

        // Enter the password retrieved from the configuration file
        practiceLoginPage.password.sendKeys(ConfigurationReader.getProperty("password.login2"));

        // Click the login button
        practiceLoginPage.loginButton.click();

        // Close the driver session
        Driver.closeDriver();
    }
}

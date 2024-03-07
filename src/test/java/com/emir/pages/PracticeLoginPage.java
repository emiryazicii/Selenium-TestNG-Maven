package com.emir.pages;

import com.emir.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the login page of a practice application.
 */
public class PracticeLoginPage {

    /**
     * Constructor to initialize the page elements.
     */
    public PracticeLoginPage(){
        // Initialize page elements using PageFactory
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // WebElement representing the username input field
    @FindBy(name = "username")
    public WebElement username;

    // WebElement representing the password input field
    @FindBy(name = "password")
    public WebElement password;

    // WebElement representing the login button
    @FindBy(id = "wooden spoon")
    public WebElement loginButton;
}

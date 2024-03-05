package com.emir.pages;

import com.emir.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the Library Login page.
 * Contains WebElement definitions and methods to interact with the elements on the page.
 */
public class LibraryLoginPage {

    /**
     * Constructor to initialize elements of the page using PageFactory.
     */
    public LibraryLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * WebElement representing the Sign In button.
     */
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSignIn;

    /**
     * WebElement representing the field required error message.
     */
    @FindBy(id = "inputEmail-error")
    public WebElement fieldRequiredErrorMessage;

    /**
     * WebElement representing the email input box.
     */
    @FindBy(id = "inputEmail")
    public WebElement emailInputBox;

    /**
     * WebElement representing the invalid email error message.
     */
    @FindBy(id = "inputEmail-error")
    public WebElement invalidEmailErrorMessage;

    /**
     * WebElement representing the password input box.
     */
    @FindBy(id = "password")
    public WebElement passwordInputBox;

    /**
     * WebElement representing the message for wrong email or password.
     */
    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordMessage;
}

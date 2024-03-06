package com.emir.pages;

import com.emir.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the Dynamic Controls page.
 * Contains WebElement definitions and methods to interact with the elements on the page.
 */
public class DynamicControlsPage {

    /**
     * Constructor to initialize elements of the page using PageFactory.
     */
    public DynamicControlsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * WebElement representing the Remove button.
     */
    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    /**
     * WebElement representing the loading bar.
     */
    @FindBy(id = "loading")
    public WebElement loadingBar;

    /**
     * WebElement representing the checkbox element.
     */
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    /**
     * WebElement representing the message indicating that the element is gone.
     */
    @FindBy(id = "message")
    public WebElement itsGoneMessage;

    /**
     * WebElement representing the Enable button.
     */
    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    /**
     * WebElement representing the input text box.
     */
    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;


}

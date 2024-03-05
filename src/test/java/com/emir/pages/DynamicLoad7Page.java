package com.emir.pages;

import com.emir.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the Dynamic Load 7 page.
 * Contains WebElement definitions for elements on the page.
 */
public class DynamicLoad7Page {

    /**
     * Constructor to initialize elements of the page using PageFactory.
     */
    public DynamicLoad7Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * WebElement representing the "Done!" message element.
     */
    @FindBy(xpath = "//strong")
    public WebElement doneMessage;

    /**
     * WebElement representing the image element.
     */
    @FindBy(xpath = "//img")
    public WebElement image;
}

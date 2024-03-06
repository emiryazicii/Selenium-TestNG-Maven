package com.emir.pages;

import com.emir.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the W3Page.
 * Contains WebElement definitions and methods to interact with the elements on the page.
 */
public class W3Page {

    /**
     * Constructor to initialize elements of the page using PageFactory.
     */
    public W3Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * WebElement representing the paragraph element on the page.
     */
    @FindBy(id = "demo")
    public WebElement paragraph;
}

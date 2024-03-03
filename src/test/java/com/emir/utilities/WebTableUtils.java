package com.emir.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * A utility class for web table operations.
 */
public class WebTableUtils {

    /**
     * Returns the order date of a customer from the web table.
     *
     * @param driver       WebDriver instance.
     * @param customerName The name of the customer whose order date needs to be retrieved.
     * @return The order date of the customer as a String.
     */
    public static String returnOrderDate(WebDriver driver, String customerName) {
        // Find the order date cell for the given customer name
        WebElement orderDateCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='" + customerName +
                "']/following-sibling::td[3]"));
        // Return the text of the order date cell
        return orderDateCell.getText();
    }

    /**
     * Verifies if the order date of a customer matches the expected order date.
     *
     * @param driver            WebDriver instance.
     * @param customerName      The name of the customer whose order date needs to be verified.
     * @param expectedOrderDate The expected order date of the customer.
     * @return true if the actual order date matches the expected order date, false otherwise.
     */
    public static boolean verifyOrderDate(WebDriver driver, String customerName, String expectedOrderDate) {
        // Find the order date cell for the given customer name
        WebElement orderDateCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='" +
                customerName + "']/following-sibling::td[3]"));
        // Return true if the actual order date matches the expected order date, false otherwise
        return orderDateCell.getText().equals(expectedOrderDate);
    }

    /**
     * Retrieves the email of a person from the specified table using their first name.
     *
     * @param driver    WebDriver instance.
     * @param tableNum  The table number in the HTML (e.g., "1", "2", etc.).
     * @param firstName The first name of the person whose email needs to be retrieved.
     * @return The email of the person as a String.
     */
    public static String getEmailFromTable(WebDriver driver, String tableNum, String firstName) {
        // Construct the XPath to locate the email cell based on the table number and first name
        String xpath = "//table[@id='table2']//td[.='Jason']/following-sibling::td[1]";
        // Find the email cell using the constructed XPath
        WebElement emailCell = driver.findElement(By.xpath(xpath));
        // Return the text of the email cell
        return emailCell.getText();
    }
}

/*
TC #2: Web table practice Task1 cont.
1. Create a new class called WebTableUtils.
2. Create two methods to verify order
Method #1 info:
• Name: returnOrderDate ()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String costumerName
This method should accept a costumerName and return the costumer order date
as a String.


Method #2 info:
• Name: orderVerify ()
• Return type: boolean
• Arg1: WebDriver driver
• Arg2: String costumerName
• Arg3: String expectedOrderDate
This method should accept above mentioned arguments and internally verify
expectedOrderDate matching actualOrderDate


TC #3: Create a custom method
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/tables
3- Write custom method:
• Method name: getTableGetEmail()
• Return type: String
• Arg1: WebDriver driver
• Arg2: String tableNum
• Arg3: String firstName
 */
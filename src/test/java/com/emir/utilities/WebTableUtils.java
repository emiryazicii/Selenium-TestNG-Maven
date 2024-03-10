package com.emir.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * A utility class for web table operations.
 */
public class WebTableUtils {

    /**
     * Returns the order date of a customer from the web table.
     *
     * @param customerName The name of the customer whose order date needs to be retrieved.
     * @return The order date of the customer as a String.
     */
    public static String returnOrderDate(String customerName) {
        // Find the order date cell for the given customer name
        WebElement orderDateCell = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='" + customerName +
                "']/following-sibling::td[3]"));
        // Return the text of the order date cell
        return orderDateCell.getText();
    }

    /**
     * Verifies if the order date of a customer matches the expected order date.
     *
     * @param customerName      The name of the customer whose order date needs to be verified.
     * @param expectedOrderDate The expected order date of the customer.
     * @return true if the actual order date matches the expected order date, false otherwise.
     */
    public static boolean verifyOrderDate(String customerName, String expectedOrderDate) {
        // Find the order date cell for the given customer name
        WebElement orderDateCell = Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='" +
                customerName + "']/following-sibling::td[3]"));
        // Return true if the actual order date matches the expected order date, false otherwise
        return orderDateCell.getText().equals(expectedOrderDate);
    }

    /**
     * Retrieves the email of a person from the specified table using their first name.
     *
     * @param tableNum  The table number in the HTML (e.g., "1", "2", etc.).
     * @param firstName The first name of the person whose email needs to be retrieved.
     * @return The email of the person as a String.
     */
    public static String getEmailFromTable(String tableNum, String firstName) {
        // Construct the XPath to locate the email cell based on the table number and first name
        String xpath = "//table[@id='table2']//td[.='Jason']/following-sibling::td[1]";
        // Find the email cell using the constructed XPath
        WebElement emailCell = Driver.getDriver().findElement(By.xpath(xpath));
        // Return the text of the email cell
        return emailCell.getText();
    }
}

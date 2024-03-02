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
     * @param driver           WebDriver instance.
     * @param customerName     The name of the customer whose order date needs to be verified.
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
 */
package com.emir.tests.quick_reviews;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * This class demonstrates the usage of hard and soft assertions in TestNG.
 */
public class SoftAndHardAssertions {

    /**
     * Test method demonstrating hard assertion.
     */
    @Test
    public void hardAssertionTest(){
        // Print a message indicating that this is a hard assertion
        System.out.println("This is hard assertion.");

        // Perform a hard assertion (will fail)
        Assert.assertEquals("apple", "app");

        // This line won't be executed if the hard assertion fails
        System.out.println("After hard assertion failed.");
    }

    /**
     * Test method demonstrating soft assertion.
     */
    @Test
    public void softAssertionTest(){
        // Print a message indicating that this is a soft assertion
        System.out.println("This is soft assertion");

        // Initialize SoftAssert object
        SoftAssert softAssert = new SoftAssert();

        // Perform a soft assertion (will fail)
        softAssert.assertEquals("orange", "org");

        // This line will be executed even if the soft assertion fails
        System.out.println("After soft assertion failed.");

        // Call assertAll() to mark all soft assertions
        softAssert.assertAll();
    }
}

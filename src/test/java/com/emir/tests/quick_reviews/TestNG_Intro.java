package com.emir.tests.quick_reviews;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class demonstrates the basic usage of TestNG for writing test cases.
 */
public class TestNG_Intro {

    /**
     * Test case to validate the addition operation.
     */
    @Test
    public void testTwoPlusFive(){
        // Verify that 2 + 5 equals 7
        Assert.assertEquals(2 + 5, 7);

        // Verify that 2 + 5 equals 9 (this assertion will fail)
        Assert.assertTrue(2 + 5 == 9);
    }

    /**
     * Test case to validate the equality of two strings.
     */
    @Test
    public void testApple(){
        // Verify that the string "apple" equals "orange" (this assertion will fail)
        Assert.assertEquals("apple", "orange");
    }
}

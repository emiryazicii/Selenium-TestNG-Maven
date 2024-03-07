package com.emir.tests.quick_reviews;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class demonstrates the usage of TestNG annotations @BeforeMethod and @AfterMethod.
 */
public class BeforeAndAfterMethodAnnotations {

    /**
     * Setup method executed before each test method.
     */
    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before method is running.");
    }

    /**
     * Teardown method executed after each test method.
     */
    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running");
    }

    /**
     * Test method with priority 3.
     */
    @Test(priority = 3)
    public void test1(){
        System.out.println("Test1 is running.");
    }

    /**
     * Test method with priority 2.
     */
    @Test(priority = 2)
    public void test2(){
        System.out.println("Test2 is running");
    }

    /**
     * Test method with priority 1.
     */
    @Test(priority = 1)
    public void test3(){
        System.out.println("Test3 is running.");
    }
}

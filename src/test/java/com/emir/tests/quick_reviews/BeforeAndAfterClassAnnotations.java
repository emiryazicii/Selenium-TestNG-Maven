package com.emir.tests.quick_reviews;

import org.testng.annotations.*;

/**
 * This class demonstrates the usage of TestNG annotations @BeforeClass, @AfterClass, @BeforeMethod, @AfterMethod, and @Test.
 */
public class BeforeAndAfterClassAnnotations {

    /**
     * Setup method executed before the class.
     */
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class is running");
    }

    /**
     * Teardown method executed after the class.
     */
    @AfterClass
    public void afterClass(){
        System.out.println("After class is running.");
    }

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

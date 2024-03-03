package com.emir.tests.lesson09_review_javafaker_driverUtil;

import org.testng.annotations.Test;

/**
 * A test class to understand the behavior of the Singleton class.
 */
public class SingletonPractice {

    /**
     * Test method to understand the Singleton class behavior.
     */
    @Test
    public void singleton_understanding_test1(){

        // Get the word instance for the first time
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        // Get the word instance for the second time
        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        // Get the word instance for the third time
        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }
}

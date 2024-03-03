package com.emir.tests.lesson09_review_javafaker_driverUtil;

/**
 * A Singleton class to ensure only one instance of a variable is created.
 */
public class Singleton {

    // Private constructor to prevent instantiation from outside
    private Singleton(){
    }

    // Static variable to hold the single instance of the word
    private static String word; // by default, the word is null.

    /**
     * Static method to get the single instance of the word.
     * @return the word instance
     */
    public static String getWord(){

        // Check if the word instance is null
        if(word == null){
            System.out.println("First time call. Word object is null.");
            System.out.println("Assigning value to it now.");
            word = "something";
        } else {
            System.out.println("Word already has a value.");
        }

        // Return the word instance
        return word;
    }
}


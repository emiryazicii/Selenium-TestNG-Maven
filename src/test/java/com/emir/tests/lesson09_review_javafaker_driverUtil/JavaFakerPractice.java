package com.emir.tests.lesson09_review_javafaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

/**
 * A test class to demonstrate the usage of JavaFaker library.
 */
public class JavaFakerPractice {

    // Create a Faker object
    Faker faker = new Faker();

    /**
     * Test method to generate and print various types of fake data using JavaFaker.
     */
    @Test
    public void java_faker_test() {
        // Print a random first name
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        // Print a random last name
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        // Print a random full name
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        // Print a random city name
        System.out.println("faker.address().city() = " + faker.address().city());

        // Print a random full address
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());

        // Print a random birthday between the years 1952 and 1971
        System.out.println("faker.date().birthday(19, 52) = " + faker.date().birthday(19, 52));

        // Print a random phone number in the format ###-###-####
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));

        // Print a random phone number in the format 412-###-####
        System.out.println("faker.numerify(\"412-###-####\") = " + faker.numerify("412-###-####"));

        // Print a random string of 9 characters
        System.out.println("faker.letterify(\"?????????\") = " + faker.letterify("?????????"));

        // Print a random string of characters with the pattern ??###?#?###???#??###
        System.out.println("faker.bothify(\"??###?#?###???#??###\") = " + faker.bothify("??###?#?###???#??###"));
    }
}

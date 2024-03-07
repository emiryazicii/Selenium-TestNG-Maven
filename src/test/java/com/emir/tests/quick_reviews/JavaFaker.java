package com.emir.tests.quick_reviews;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

/**
 * This class demonstrates the usage of JavaFaker library to generate fake data.
 */
public class JavaFaker {

    /**
     * Test method to generate fake data using JavaFaker.
     */
    @Test
    public void java_faker_test(){
        // Create a Faker instance
        Faker faker = new Faker();

        // Generate and print a fake full name
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        // Generate and print a fake full address
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());

        // Generate and print a fake birthday
        System.out.println("faker.date().birthday() = " + faker.date().birthday());

        // Generate and print a fake Social Security Number
        System.out.println("faker.numerify(\"###-##-####\") = " + faker.numerify("###-##-####"));

        // Generate and print a fake cell phone number
        System.out.println("faker.phoneNumber().cellPhone() = " + faker.phoneNumber().cellPhone());

        // Generate and print a fake alphanumeric string with specified pattern
        System.out.println("faker.bothify(\"##??#?###??#???#?\") = " + faker.bothify("##??#?###??#???#?"));

        // Generate and print a fake string with specified pattern of letters
        System.out.println("faker.letterify(\"?????????\") = " + faker.letterify("?????????"));
    }
}

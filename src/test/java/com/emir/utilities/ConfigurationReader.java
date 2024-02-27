package com.emir.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigurationReader is a utility class to read configuration properties from a file.
 */
public class ConfigurationReader {

    // Using private static fields to hold properties to ensure they are accessible only within this class
    private static Properties properties = new Properties();

    // Static initializer block to load properties from the file when the class is loaded
    static {
        try {
            // Loading properties from a file named "configuration.properties"
            FileInputStream fis = new FileInputStream("configuration.properties");
            properties.load(fis); // Loading properties from the file
            fis.close(); // Closing the FileInputStream
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!"); // Handling file not found exception
            e.printStackTrace(); // Printing stack trace for debugging purposes
        }
    }

    /**
     * Get the value of a property by its keyword.
     *
     * @param keyword The keyword of the property whose value is to be retrieved.
     * @return The value of the property corresponding to the given keyword.
     */
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword); // Returning the value of the property associated with the given keyword
    }
}


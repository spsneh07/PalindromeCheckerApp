/**
 * Use Case 1: Palindrome Checker App
 * Objective: Display welcome message and application details
 */

public class UseCase1PalindromeCheckerApp {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String VERSION = "Version 1.0";

    /**
     * Entry point of the application
     * JVM starts execution from here
     */
    public static void main(String[] args) {

        // Display welcome message
        displayWelcomeMessage();

        // Application flow continues
        System.out.println("\nApplication initialized successfully.");
        System.out.println("Ready for palindrome validation in next use case.");
    }

    /**
     * Displays application name and version
     */
    public static void displayWelcomeMessage() {
        System.out.println("======================================");
        System.out.println("        " + APP_NAME);
        System.out.println("        " + VERSION);
        System.out.println("======================================");
        System.out.println("Welcome to the Palindrome Checker Application!");
    }
}
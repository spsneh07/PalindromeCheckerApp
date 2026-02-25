/**
 * Use Case 2: Print a Hardcoded Palindrome Result
 * Objective: Check whether a hardcoded string is a palindrome
 */

public class UseCase2PalindromeCheckerApp {

    /**
     * Entry point of the application
     */
    public static void main(String[] args) {

        // Hardcoded string literal
        String word = "madam";

        // Reverse the string
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        // Check palindrome using if-else
        if (word.equals(reversed)) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        // Program exits
    }
}
/**
 * Use Case 9: Recursive Palindrome Checker
 * Objective: Check palindrome using recursion
 */

public class UseCase9PalindromeCheckerApp {

    /**
     * Entry point of the application
     */
    public static void main(String[] args) {

        String word = "madam";

        boolean result = isPalindrome(word, 0, word.length() - 1);

        System.out.println("Original String: " + word);

        if (result) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }

    /**
     * Recursive method to check palindrome
     */
    public static boolean isPalindrome(String word, int start, int end) {

        // Base condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters do not match
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(word, start + 1, end - 1);
    }
}
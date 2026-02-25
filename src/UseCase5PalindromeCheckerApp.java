/**
 * Use Case 5: Stack-Based Palindrome Checker
 * Objective: Use Stack to reverse characters and validate palindrome
 */

import java.util.Stack;

public class UseCase5PalindromeCheckerApp {

    /**
     * Entry point of the application
     */
    public static void main(String[] args) {

        // Original string
        String word = "madam";

        // Create a Stack of Characters
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;

        // Pop characters and compare
        for (int i = 0; i < word.length(); i++) {
            char poppedChar = stack.pop();

            if (word.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        System.out.println("Original String: " + word);

        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}
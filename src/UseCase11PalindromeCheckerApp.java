/**
 * Use Case 11: Object-Oriented Palindrome Service
 * Encapsulates palindrome logic in a class
 */

import java.util.Stack;

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Radar";

        // Step 1: Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Step 2: Check palindrome
        boolean result = checker.checkPalindrome(input);

        System.out.println("Input: " + input);

        if (result) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}

/**
 * PalindromeChecker Class
 * Encapsulates palindrome logic
 */
class PalindromeChecker {

    /**
     * Check if a string is a palindrome
     * Uses stack internally
     */
    public boolean checkPalindrome(String str) {

        if (str == null || str.isEmpty()) {
            return true;
        }

        // Normalize string: ignore case
        str = str.toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters to stack
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop and compare
        for (char ch : str.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}
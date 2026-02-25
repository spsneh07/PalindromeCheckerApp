/**
 * Use Case 4: Character Array Based Palindrome Check
 * Objective: Convert string to char[] and use two-pointer technique
 */

public class UseCase4PalindromeCheckerApp {

    /**
     * Entry point of the application
     */
    public static void main(String[] args) {

        // Original string
        String word = "radar";

        // Convert string to character array
        char[] characters = word.toCharArray();

        // Two-pointer approach
        int start = 0;
        int end = characters.length - 1;

        boolean isPalindrome = true;

        while (start < end) {

            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        // Display result
        System.out.println("Original String: " + word);

        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }
}
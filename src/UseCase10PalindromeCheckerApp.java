/**
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome Checker
 * Objective: Ignore spaces and case while checking palindrome
 */

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        String phrase = "A man a plan a canal Panama";

        // Step 1: Normalize string (remove spaces, lowercase)
        String normalized = phrase.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(normalized);

        System.out.println("Original Phrase: " + phrase);

        if (result) {
            System.out.println("Result: It is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }

    // Two-pointer palindrome check
    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
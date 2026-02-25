/**
 * Use Case 13: Performance Comparison
 * Compares execution time of multiple palindrome algorithms
 */

import java.util.*;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama".replaceAll("\\s+", "").toLowerCase();
        System.out.println("Input string length: " + input.length());

        // List of strategies
        Map<String, PalindromeStrategy> strategies = new LinkedHashMap<>();
        strategies.put("Stack Strategy", new StackStrategy());
        strategies.put("Deque Strategy", new DequeStrategy());
        strategies.put("Two-Pointer Strategy", new TwoPointerStrategy());
        strategies.put("Recursive Strategy", new RecursiveStrategy());

        // Compare performance
        System.out.println("\n=== Performance Comparison ===");
        for (Map.Entry<String, PalindromeStrategy> entry : strategies.entrySet()) {
            String name = entry.getKey();
            PalindromeStrategy strategy = entry.getValue();

            long start = System.nanoTime();
            boolean result = strategy.isPalindrome(input);
            long end = System.nanoTime();

            System.out.printf("%-20s: %-10s | Time: %.3f ms%n",
                    name, result ? "Palindrome" : "NOT Palindrome", (end - start) / 1_000_000.0);
        }
    }
}

/**
 * PalindromeStrategy interface
 */
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

/**
 * Stack-Based Strategy
 */
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) if (stack.pop() != ch) return false;
        return true;
    }
}

/**
 * Deque-Based Strategy
 */
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }
}

/**
 * Two-Pointer Strategy
 */
class TwoPointerStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) if (str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }
}

/**
 * Recursive Strategy
 */
class RecursiveStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        return check(str, 0, str.length() - 1);
    }
    private boolean check(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return check(s, left + 1, right - 1);
    }
}
/**
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 * Goal: Choose palindrome algorithm dynamically
 */

import java.util.*;

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Level";

        // Step 1: Select strategy dynamically
        PalindromeStrategy strategy;

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Palindrome Strategy:");
        System.out.println("1: Stack-Based");
        System.out.println("2: Deque-Based");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        switch (choice) {
            case 1:
                strategy = new StackStrategy();
                break;
            case 2:
                strategy = new DequeStrategy();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Stack Strategy.");
                strategy = new StackStrategy();
        }

        // Step 2: Check palindrome using chosen strategy
        boolean result = strategy.isPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Strategy: " + strategy.getClass().getSimpleName());
        System.out.println("Result: " + (result ? "Palindrome" : "NOT Palindrome"));

        sc.close();
    }
}

/**
 * PalindromeStrategy Interface
 */
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}

/**
 * Stack-Based Strategy
 */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        str = str.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (stack.pop() != ch) return false;
        }

        return true;
    }
}

/**
 * Deque-Based Strategy
 */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        str = str.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}
/**
 * Use Case 8: Linked List Based Palindrome Checker
 * Objective: Check palindrome using Singly Linked List
 */

public class UseCase8PalindromeCheckerApp {

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Entry point
     */
    public static void main(String[] args) {

        String word = "level";

        // Step 1: Convert String to Linked List
        Node head = createLinkedList(word);

        // Step 2: Check Palindrome
        boolean result = isPalindrome(head);

        System.out.println("Original String: " + word);

        if (result) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }
    }

    // Create linked list from string
    public static Node createLinkedList(String word) {
        Node head = new Node(word.charAt(0));
        Node current = head;

        for (int i = 1; i < word.length(); i++) {
            current.next = new Node(word.charAt(i));
            current = current.next;
        }

        return head;
    }

    // Palindrome logic using Fast & Slow pointer
    public static boolean isPalindrome(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Find middle of list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Compare both halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Reverse linked list in-place
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
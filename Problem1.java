// https://leetcode.com/problems/add-two-numbers/

// Problem1.java

// Definition of a ListNode class
class ListNode {
    int val; // Value of the node
    ListNode next; // Reference to the next node

    // Constructor to initialize the node with a given value
    ListNode(int val) {
        this.val = val;
    }
}

// Problem1 class to solve the specified problem
public class Problem1 {
    // Method to add two numbers represented as linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the code
        ListNode l3 = new ListNode(0);
        ListNode head = l3; // Keep track of the head of the result list
        int carry = 0; // Variable to store the carry during addition

        // Iterate through the linked lists until both are null
        while (l1 != null || l2 != null) {
            // Extract values of the current nodes, default to 0 if null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate the sum of current nodes and carry
            int sum = x + y + carry;
            carry = sum / 10; // Update carry for the next iteration

            // Create a new node with the digit of the sum, add to result list
            l3.next = new ListNode(sum % 10);
            l3 = l3.next; // Move to the next node in the result list

            // Move to the next nodes in l1 and l2 if they are not null
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // If there's a remaining carry, add a new node to the result list
        if (carry > 0) {
            l3.next = new ListNode(carry);
        }

        // Return the next node of the dummy node, skipping the initial 0
        return head.next;
    }
}
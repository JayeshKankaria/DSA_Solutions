/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null; // Added for temporary storage of next node
        // Count total nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) 
        {
            temp = temp.next;
            count++;
        }
        if (count < k) // If less than k nodes, no need to reverse
            return head;
  
        int i = 0;
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k); // Recur for the rest of the list
        }
        return prev;
    }
}
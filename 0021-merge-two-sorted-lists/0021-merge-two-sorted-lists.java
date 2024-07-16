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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode merged = new ListNode();
        merge(list1,list2,merged);
        return merged.next;
    }
    public static void merge(ListNode list1, ListNode list2,ListNode merged)
    {
        ListNode tail = merged;
        if(list1 == null)
        {
            tail.next=list2;
            return;
        }
        if(list2 == null)
        {
            tail.next=list1;
            return;
        }
        if(list1.val<list2.val)
        {
            tail.next=list1;
            merge(list1.next,list2,tail.next);
        }
        else
        {
            tail.next=list2;
            merge(list1,list2.next,tail.next);
        }
    }
}
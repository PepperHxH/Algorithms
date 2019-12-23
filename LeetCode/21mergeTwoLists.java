/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        //iterative method
        if(l1 == null && l2 == null) return null;
        ListNode head = new ListNode(0);
        ListNode t = head;
        while(l1 != null || l2 != null) {
            int v1 = (l1 == null) ? Integer.MAX_VALUE : l1.val;
            int v2 = (l2 == null) ? Integer.MAX_VALUE : l2.val;
            ListNode node;
            if(v1 <= v2) {
                node = new ListNode(v1);
                l1 = l1.next;
            } else {
                node = new ListNode(v2);
                l2 = l2.next;
            }
            t.next = node;
            t = node;
        }
        t.next = null;
        return head.next;
        */
        //recursive method
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
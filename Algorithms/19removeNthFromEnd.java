/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        ListNode slow, fast;
        slow = fast = head;
        while(n-- != 0) {
            fast = fast.next;
        }
        //当正好要去除的是头结点时，要另分情况！
        if(fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = fast.next;
        return head;
        */
        
        //better solution
        ListNode start = new ListNode(0);
        ListNode fast = start, slow = start;
        slow.next = head;
        
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
        
    }
}
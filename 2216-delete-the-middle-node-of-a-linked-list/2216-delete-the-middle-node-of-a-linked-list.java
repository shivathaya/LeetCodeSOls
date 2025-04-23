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
    public ListNode deleteMiddle(ListNode head) {
        ListNode middle = null;
        ListNode slow = head;
        ListNode fast = head;

        if(slow == null || slow.next == null){
            return null;
        }

        while(fast != null && fast.next != null){
            middle = slow;
            slow = slow.next;
            fast  = fast.next.next;
        }
        middle.next = slow.next;

        return head;
    }
}

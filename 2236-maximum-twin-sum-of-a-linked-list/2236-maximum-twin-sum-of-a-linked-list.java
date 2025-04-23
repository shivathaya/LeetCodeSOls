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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode sec = reverseList(slow);
        int maxSum = 0;
        ListNode first = head;

        while(sec != null){
            maxSum = Math.max(maxSum, first.val+sec.val);
            first = first.next;
            sec = sec.next;
        }
        return maxSum;
        
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newH = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newH;
    }
}
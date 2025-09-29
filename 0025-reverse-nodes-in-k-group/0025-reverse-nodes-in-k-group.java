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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (true) {
            // Find the kth node from prevGroup
            ListNode kth = getKth(prevGroup, k);
            if (kth == null) break;  // not enough nodes left
            ListNode nextGroup = kth.next;

            // Reverse current group
            ListNode prev = kth.next;
            ListNode curr = prevGroup.next;
            while (curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Connect reversed group back
            ListNode tmp = prevGroup.next;  // will become tail after reverse
            prevGroup.next = kth;
            prevGroup = tmp;
        }

        return dummy.next;
    }
    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
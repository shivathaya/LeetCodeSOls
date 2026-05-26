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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = null;
            } else{
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}
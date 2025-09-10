/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode l = head;
        ListNode r = head.next.next;

        while(r != null){
            if(r == l) return true;
            l = l.next;
            if(r.next != null)
                r= r.next.next;
            else return false;
        }
        return false;
    }
}
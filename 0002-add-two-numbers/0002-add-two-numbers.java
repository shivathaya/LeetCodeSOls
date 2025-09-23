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
 import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(l1 != null){
            sb1.insert(0,l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            sb2.insert(0,l2.val);
            l2 = l2.next;
        }

        BigInteger n1 = new BigInteger(sb1.toString());
        BigInteger n2 = new BigInteger(sb2.toString());
        BigInteger sum = n1.add(n2);

        System.out.println(sum);

        String sm = new StringBuilder(sum.toString()).reverse().toString();
        ListNode temp = new ListNode(0);
        ListNode pt = temp;
        for(char c: sm.toCharArray()){
            pt.next = new ListNode(c -'0');
            pt = pt.next;
        }
        return temp.next;

    }
    // no need to do all these use recursion with carry
    /* 
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addRecursive(l1, l2, 0);
    }

    private ListNode addRecursive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;

        int sum = x + y + carry;
        ListNode node = new ListNode(sum % 10);
        node.next = addRecursive(
            (l1 != null) ? l1.next : null,
            (l2 != null) ? l2.next : null,
            sum / 10
        );
        return node;
    }
    */
}
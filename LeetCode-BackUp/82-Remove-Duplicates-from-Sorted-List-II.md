```
// solved by myself
// 但是想的时间比较长


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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        
        ListNode dummy = new ListNode(101);
        dummy.next = head;
        
        ListNode prev1 = dummy;
        ListNode prev2 = head;
        ListNode node = head.next;
        
        while (node != null) {
            while (node != null && node.val == prev2.val) {
                node = node.next;
            }
            
            if (node == null) {
                prev1.next = node;
            } else if (prev2.next != node) {
                prev1.next = node;
                prev2 = node;
                node = node.next;
            } else {
                prev1 = prev2;
                prev2 = node;
                node = node.next;
            }

        }
        
        return dummy.next;
    }
}

```
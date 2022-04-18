```
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        // length
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        
        // optimize time complexity
        k = k % length;
        

        // rotate
        for (int i = 0; i < k; i++) {
            
            ListNode pretail = head;
            while (pretail.next.next != null) {
            pretail = pretail.next;
            }
            ListNode tail = pretail.next;
            
            tail.next = head;
            pretail.next = null;
            head = tail;
        }
        return head;
    }
}
```
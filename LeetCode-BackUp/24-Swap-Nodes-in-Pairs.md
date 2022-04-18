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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        ListNode answer = head.next;
        ListNode node = head;
        ListNode dummy = new ListNode(0, head);
        
        // node != null && node.next != null 成对出现
        while (node != null && node.next != null) {
            // nodes to be swapped：node1 and node2
            ListNode node1 = node;
            ListNode node2 = node.next;
            // swap
            dummy.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // prepare for the next swap
            dummy = node;
            node = node.next;
        }
        return answer;
    }
}
```
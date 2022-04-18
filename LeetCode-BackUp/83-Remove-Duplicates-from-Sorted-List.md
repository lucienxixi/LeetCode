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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode leftNode = head;
        ListNode rightNode = leftNode.next;
        while (rightNode != null) {
            while (rightNode != null && leftNode.val == rightNode.val) {
                rightNode = rightNode.next;
            }
            leftNode.next = rightNode;
            if (rightNode == null) {
                break;
            }
            leftNode = rightNode;
            rightNode = rightNode.next;
        }
        return head;
    }
}
```
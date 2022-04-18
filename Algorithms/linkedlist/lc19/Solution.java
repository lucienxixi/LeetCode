package linkedlist.lc19;
/*
  lc19. Remove Nth Node From End of List
 */
import linkedlist.ListNode;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return null;
        }

        // size
        ListNode node = head;
        int size = 1;
        while (node != null && node.next != null) {
            node = node.next;
            size++;
        }
        // find
        ListNode dummyNode = new ListNode(0, head);
        ListNode removeNode = dummyNode;
        for (int i = 0; i < size - n; i++) {
            removeNode = removeNode.next;
        }
        // remove
        removeNode.next = removeNode.next.next;
        // 不返回head是因为在case: [1], n = 1的情况下，head还是[1],而不是[]。
        return dummyNode.next;
    }
}
package twopointerssamedirection.linkedlistcycle.lc876;

import twopointerssamedirection.linkedlistcycle.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {   // && 不是 ||
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

package twopointerssamedirection.linkedlistcycle.lc142;

import twopointerssamedirection.linkedlistcycle.ListNode;

class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = head;
        while (slow != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
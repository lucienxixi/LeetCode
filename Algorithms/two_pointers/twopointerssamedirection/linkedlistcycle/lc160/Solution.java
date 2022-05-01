package twopointerssamedirection.linkedlistcycle.lc160;

import twopointerssamedirection.linkedlistcycle.ListNode;

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // create a cycle: c3->b1
        ListNode node1 = headA;
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = headB;

        ListNode slow = headA;
        ListNode fast = headA.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                node1.next = null; // retain their original structure
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = headA;
        while (slow != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        node1.next = null; // retain their original structure
        return slow;
    }
}

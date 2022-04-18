package twopointerssamedirection.linkedlistcycle.lc876;

import twopointerssamedirection.linkedlistcycle.ListNode;

class Solution1 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        int index = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            index++;
        }

        ListNode middleNode = head;
        for (int i = 1; i < index / 2 + 1; i++) {
            middleNode = middleNode.next;
        }

        return middleNode;
    }
}

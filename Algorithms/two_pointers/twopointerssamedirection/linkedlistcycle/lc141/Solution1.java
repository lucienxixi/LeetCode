package twopointerssamedirection.linkedlistcycle.lc141;

import twopointerssamedirection.linkedlistcycle.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public boolean hasCycle(ListNode head) {

        Set<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (!hashSet.contains(head)) {
                hashSet.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }
}


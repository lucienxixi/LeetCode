package twopointerssamedirection.linkedlistcycle.lc160;

import twopointerssamedirection.linkedlistcycle.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<ListNode>();

        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (hashSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
package twopointerssamedirection.linkedlistcycle.lc142;

import twopointerssamedirection.linkedlistcycle.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            if (!hashSet.contains(head)) {
                hashSet.add(head);
                head = head.next;
            } else {
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        System.out.println(a && b);
        System.out.println(a || b);
    }
}
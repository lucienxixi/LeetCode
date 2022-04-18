package linkedlist.lc21;

import linkedlist.ListNode;
/*
lc21. Merge Two Sorted Lists
 */
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode curNode1 = l1;
        ListNode curNode2 = l2;
        ListNode preNode2 = new ListNode(0, curNode2);
        ListNode answerNode = preNode2;
        while (curNode1 != null || curNode2 != null) {
            if (curNode1 == null) {
                preNode2.next = curNode2;
                break;
            } else if (curNode2 == null) {
                preNode2.next = curNode1;
                break;
            } else if (curNode2.val <= curNode1.val) {
                preNode2.next = curNode2;
                preNode2 = curNode2;
                curNode2 = curNode2.next;
            } else {
                preNode2.next = curNode1;
                preNode2 = curNode1;
                curNode1 = curNode1.next;
            }
        }
        return answerNode.next;
    }
}
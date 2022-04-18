package linkedlist.lc92;
/*
  lc92. Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode answerNode = head;

        // find left - 1
        ListNode curNode1 = head;
        for (int i = 1; i < left - 1; i++) {
            curNode1 = curNode1.next;
        }
        ListNode leftNode;
        //当left==1时，要加一个dummyNode在开头。
        if (left != 1) {
            leftNode = curNode1;
        } else {
            leftNode = new ListNode(0, curNode1);
        }

        // find right + 1
        ListNode curNode2 = head;
        for (int i = 1; i < right + 1; i++) {
            curNode2 = curNode2.next;
        }
        ListNode rightNode = curNode2;

        // reverse list from left to right
        ListNode curNode3 = leftNode.next;
        ListNode preNode = rightNode;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = curNode3.next;
            curNode3.next = preNode;
            preNode = curNode3;
            curNode3 = nextNode;
        }
        leftNode.next = preNode;

        if (left != 1) {
            return answerNode;
        } else {
            return leftNode.next;
        }
    }
}
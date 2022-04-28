// 2130. Maximum Twin Sum of a Linked List

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

// solved by myself
class Solution {
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        
        // get length
        int length = 0;
        ListNode p1 = head;
        while (p1 != null) {
            length++;
            p1 = p1.next;
        }
        
        // reverse the first half of linked list
        ListNode curNode = head;
        ListNode preNode = null;
        
        for (int i = 0; i < length / 2; i++) {   
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        
        // calculate the sum
        ListNode left = preNode;
        ListNode right = curNode;
        int maxTwinSum = 0;
        
        for (int i = 0; i < length / 2; i++) {
            maxTwinSum = Math.max(maxTwinSum, left.val + right.val);
            left = left.next;
            right = right.next;
        }
        
        return maxTwinSum;
    }
}



class Solution1 {
    public int pairSum(ListNode head) {
        if (head == null) {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int maxTwinSum = 0;
        
        for (int i = 0; i < list.size() / 2; i++) {
            maxTwinSum = Math.max(maxTwinSum, list.get(i) + list.get(list.size() - 1 - i));
        }
        
        return maxTwinSum;
    }
}
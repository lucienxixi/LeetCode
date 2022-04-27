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
        ListNode p2 = head;
        ListNode p3 = p2.next;
        p2.next = null;
        ListNode temp = p2;
        
        for (int i = 0; i < length / 2 - 1; i++) {            
            p2 = p3;
            p3 = p3.next;
            p2.next = temp;
            temp = p2;
        }
        
        // calculate the sum
        ListNode left = p2;
        ListNode right = p3;
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
// 769. Max Chunks To Make Sorted

// 类似题目：有重复数字
//https://leetcode.com/discuss/interview-question/1734004/Amazon-SDE1-or-Phone-Interview-Qn

// 自己想复杂了，没有做出来，对于单调栈的理解不深刻
// discuss中讲解：https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/595709/Monotonic-stack-solution-with-detailed-explanation

// 这道题因为没有重复element，是permuation，所以可以不用栈解决。
// https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/1959750/JAVA-or-O(n)-or-100-Faster



/*

[0,1,3,4,2]

*/


class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            int largest = arr[i] < stack.peek() ? stack.peek() : arr[i];
   
            while (!stack.isEmpty() && arr[i] < stack.peek()) {
                stack.pop();
            }
            stack.push(largest);
        }
        
        return stack.size();
    }
}
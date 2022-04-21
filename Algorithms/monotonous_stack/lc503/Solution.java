// 环形数组解决方法：数组长度乘2，可以用取模来避免新建一个长度为2倍的数组。
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                ans[i % nums.length] = -1;
            } else {
                ans[i % nums.length] = stack.peek();
            }
            
            stack.push(nums[i % nums.length]);
        }
        
        return ans;
    }
}
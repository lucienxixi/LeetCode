// 2104. Sum of Subarray Ranges


// brute force 
// O(n^2)
class Solution1 {
    public long subArrayRanges(int[] nums) {
        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j >= 0; j--) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
}

// https://leetcode.com/problems/sum-of-subarray-ranges/discuss/1626628/O(n)-solution-with-monotonous-stack-oror-Full-explaination

// monotonous stack, based on 907. Sum of Subarray Minimums
// O(n)

public class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long[] nextMin = new long[nums.length];
        long[] prevMin = new long[nums.length];
        long[] nextMax = new long[nums.length];
        long[] prevMax = new long[nums.length];
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                nextMin[i] = nums.length;
            } else {
                nextMin[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                prevMin[i] = -1;
            } else {
                prevMin[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                nextMax[i] = nums.length;
            } else {
                nextMax[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        stack.clear();
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                prevMax[i] = -1;
            } else {
                prevMax[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        
        long sum = 0L;
        
        for (int i = 0; i < nums.length; i++) {            
            sum += nums[i] * ((nextMax[i] - i) * (i - prevMax[i]) - (nextMin[i] - i) * (i - prevMin[i]));    
        }
        

        return sum;
    }
}
package dynamicprogramming.lc53;
/*
  brute force

  time: O(n^2)
  space: O(1)
 */
class Solution1 {
    public int maxSubArray(int[] nums) {

        int largestSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j >= 0; j--) {
                currentSum += nums[j];
                largestSum = Math.max(currentSum, largestSum);
            }
        }
        return largestSum;
    }
}
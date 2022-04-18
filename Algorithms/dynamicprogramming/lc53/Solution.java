package dynamicprogramming.lc53;
/*
  lc53. Maximum Subarray

  dp
  dp function: allTimeOPT(i) = max{allTimeOPT(i-1), currentOPT(i) = max{nums[i], currentOPT(i-1)+nums[i]}}
  key point：因为需要sum最大，所以如果nums[i]为负数，不管nums[i+1]是正负，那么nums[i]一定可以舍去。

  思路：
  1.
  如果第i个数之前的sum是负数的话，那么新的连续array可以从i开始，因为i+sum < i   ->   currentOPT(i) = max{nums[i], currentOPT(i-1)+nums[i]}
  当sum<0时，currentOPT(i) = nums[i]，当sum>0时，currentOPT(i) = currentOPT(i-1)+nums[i]。
  2.
  因为会存在新开始一段连续array的情况，之前的array的sum要跟新的array的sum比较，所以需要存起来和新的比较，所以需要全局最大值allTimeOPT(i)存放，并且需要每次更新allTimeOPT(i)。

  time: O(n)
  space: O(1)
 */
class Solution {
    public int maxSubArray(int[] nums) {

        int largestSum = nums[0];
        int currentSum = nums[0];

//        不能直接取无限小，因为Integer.MIN_VALUE-1变为正数，同理MAX+1变为负数。
//        int largestSum = Integer.MIN_VALUE/2;
//        int currentSum = Integer.MIN_VALUE/2;
//        for (int i = 0; i < nums.length; i++) {

        for (int i = 1; i < nums.length; i++) {
            // if (currentSum < 0) {
            //     currentSum = nums[i];
            // } else {
            //     currentSum += nums[i];
            // }
            currentSum/* i */ = Math.max(nums[i], currentSum/* i - 1 */ + nums[i]);

            largestSum/* i */ = Math.max(largestSum/* i - 1 */, currentSum/* i */);
        }
        return largestSum;
    }

    public static void main(String[] args) {

    }
}
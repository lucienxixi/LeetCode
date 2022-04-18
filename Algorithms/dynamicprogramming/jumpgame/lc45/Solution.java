package dynamicprogramming.jumpgame.lc45;
/*
  lc45. Jump Game II

  dp
 */
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dpTable = new int[nums.length];

        // base case
        // dpTable[0] = 0;

        // bottom-up
        for (int i = 1; i < nums.length; i++) {
            dpTable[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dpTable[i] = Math.min(dpTable[i], dpTable[j] + 1);
                }
            }
        }
        return dpTable[nums.length - 1];
    }
}
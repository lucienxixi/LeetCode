package dynamicprogramming.jumpgame.lc55;
/*
  lc55. Jump Game

  dp
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        boolean[] dpTable = new boolean[nums.length];
        //base case
        dpTable[0] = true;

        //bottom-up
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dpTable[j] && nums[j] + j >= i) {
                    dpTable[i] = true;
                    break;
                }
            }
        }

        return dpTable[dpTable.length - 1];
    }
}
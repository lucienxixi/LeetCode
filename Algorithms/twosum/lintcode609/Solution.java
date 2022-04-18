package twosum.lintcode609;
/*
  lintcode609. Two Sum - Less than or equal to target

  排序->相向双指针

  time：O(nlogn)
  排序的时间是O(nlogn)，双指针的时间是O(n)
  space：O(1)

 */

import java.util.Arrays;

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int pairs = 0;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            }
            else {
                pairs += right - left;
                left++;
            }
        }
        return pairs;

    }

    public static void main (String[] args) {
        twosum.lintcode609.Solution solution  = new twosum.lintcode609.Solution();
        int[] nums = {2,7,11,15,1,2,4,5,6,7};
        System.out.println(solution.twoSum5(nums,9));
    }
}
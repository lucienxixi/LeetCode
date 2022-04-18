package twosum.lc611;
/*
 611. Valid Triangle Number
 lintcode. Triangle Count

 思路：
 双指针变形

 三角形：a+b>c, 如果c是三个数中最大的，abc就一定是三角形。所以从小到大排序，遍历数组，每次遍历计算nums[i]前面比其小的数中存不存在两个数与nums[i]能否组成三角形。
 换而言之，计算出nums[i]前面所有满足a+b>nums[i]的组合的个数,从而转化成双指针的问题。

 time: O(n^2 + nlogn) = O(n^2)
 space: O(1)
 */
import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            count += getCount(nums, i);
        }
        return count;
    }

    private int getCount(int[] nums, int targetIndex) {
        int left = 0;
        int right = targetIndex - 1;
        int targetSum = nums[targetIndex];
        int count = 0;
        while (left < right) {
            if (nums[left] + nums[right] > targetSum) {
                count += right - left; // 时间优化：因为只需要求出个数，所当nums[left] + nums[right] > targetSum时，从left到right的之间所有的数都符合条件。
                right--;
            } else {
                left++;
            }
        }
        return count;
    }
}
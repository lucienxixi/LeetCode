package binarysearch.lc34;
/*
  lc34. Find First and Last Position of Element in Sorted Array
  lintcode1536
  重复代码需要优化。
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            int[] result1 = {-1, -1};
            return result1;
        }
        int firstPosition = binarySearchFirst(nums, target);
        int lastPosition = binarySearchLast(nums, target);
        int[] result2 = {firstPosition, lastPosition};
        return result2;
    }

    private int binarySearchFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}
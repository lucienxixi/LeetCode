package binarysearch.lc704;
/*
  双指针普通写法，只适用于经典二分问题
 */
public class Solution2 {
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // 只能判断nums[start], 不能判断nums[end]。当array=[5,7]的时候，mid和start指向5，end指向7。如果target=0，end = -1，数组下标异常。
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}

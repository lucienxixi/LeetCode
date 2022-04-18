package binarysearch.lintcode585;
// lintcode585. Maximum Number in Mountain Sequence
// 双指针
public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // write your code here
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] > nums[end]){
            return nums[start];
        } else {
            return nums[end];
        }

    }
}
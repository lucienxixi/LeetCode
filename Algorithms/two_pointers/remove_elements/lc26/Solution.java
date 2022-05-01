// 26. Remove Duplicates from Sorted Array

// 相向双指针， solution1是按九章模板做的？

class Solution1 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 1;
        int i = 0;
        
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if (j >= nums.length) {
                break;
            }
            nums[i + 1] = nums[j];
            }
        return i + 1;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        
        return slow + 1;
    }
}
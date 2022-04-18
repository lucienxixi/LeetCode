```
class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        if (target <= nums[nums.length - 1] || minIndex == 0) {
            return binarySearch(nums, minIndex, nums.length - 1, target);
        } else if (target >= nums[0]) {
            return binarySearch(nums, 0, minIndex - 1, target);
        } else {
            return -1;
        }
    }
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        } else {
            return - 1;
        }
    }
    
    private int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return start;
        } else {
            return end;
        }     
    }
}
```
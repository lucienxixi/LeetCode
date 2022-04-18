```
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            int[] result1 = {-1, -1};
            return result1;
        }
        
        int firstPosition = binarySearch(nums, target, 0, nums.length - 1);
        int lastPosition = binarySearch(nums, target, nums.length - 1, 0);
        int[] result2 = {firstPosition, lastPosition};
        return result2;
    }
    
    private int binarySearch(int[] nums, int target, int start, int end) {
        int reverse;
        if (start < end) {
            reverse = 1;
        } else {
            reverse = -1;
        }
        
        while (1 < Math.abs(start - end)) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (reverse * (nums[mid] - target) > 0) {
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
}


class Solution1 {
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
```
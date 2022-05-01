// 27. Remove Element

// 自己写的相向双指针 swap，debug了很久，while结束条件是< 还是 <= 没有想清楚。
// 相向双指针的while结束条件，和结束的时候两个指针的位置一定要想清楚。
class Solution1 {
    public int removeElement(int[] nums, int val) { 
        // if (nums.length == 1) {
        //     if (nums[0] == val) {
        //         return 0;
        //     } else {
        //         return 1;
        //     }
        // }
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            if (nums[left] != val) {
                left++;
            } else if (nums[left] == val && nums[right] == val) {
                right--;
            } else if (nums[left] == val && nums[right] != val) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        return left;
    }
}


// Solution age
// keep original order
class Solution {
    public int removeElement(int[] nums, int val) { 
        int fast = 0;
        int slow = 0;
        
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        
        return slow;
    }
}
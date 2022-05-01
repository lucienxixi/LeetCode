// 283. Move Zeroes

// 做完lc27, solved by myself
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
    
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}
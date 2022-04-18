```
// brute force
class Solution1 {
    public int maxSubArray(int[] nums) {
        // if (nums == null || nums.length == 0) {
        //     return ;
        // }
        
        int largestSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
                int currentSum = 0;
            for (int j = i; j >= 0; j--) {
                currentSum += nums[j];
                largestSum = Math.max(currentSum, largestSum);
            }
        }
        return largestSum;
    }
}



// dp
// alltimeOPT(i) = max{alltimeOPT(i-1), currentOPT(i) = max{nums[i], currentOPT(i-1)+nums[i]}}

class Solution {
    public int maxSubArray(int[] nums) {
    
        int largestSum = Integer.MIN_VALUE/2;
        int currentSum = Integer.MIN_VALUE/2;
        
        for (int i = 0; i < nums.length; i++) {
            // if (currentSum < 0) {
            //     currentSum = nums[i];
            // } else {
            //     currentSum += nums[i];
            // }
            currentSum/* i */ = Math.max(nums[i], currentSum/* i - 1 */ + nums[i]);
            
            largestSum/* i */ = Math.max(largestSum/* i - 1 */, currentSum/* i */); 
        }
        return largestSum;
    }
}

```
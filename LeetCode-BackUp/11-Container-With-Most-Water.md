```
// brute force TLE
class Solution1 {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int currArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(currArea, maxArea);
            }
        }
        return maxArea;
    }
}

// two pointers 
// 逻辑很重要，greedy思想：两指针在一头一尾，如果左边的高度更高，那么就把右指针向中间移动，反之亦然。 因为只有移动较矮边的指针才能保证新的面积有可能变大（注意是有可能），如果移动较高边的指针，新的面积一定会减小。如果左右边相等，那么移动哪边都可以。
class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int currArea = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(currArea, maxArea);
            
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;

    }
}
```
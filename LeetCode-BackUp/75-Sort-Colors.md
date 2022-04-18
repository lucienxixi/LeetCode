```
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    
    public void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        
        while (left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while(left <=right && nums[right] > pivot) {
                right--;
            }
            if(left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        quickSort(nums, start, right);
        quickSort(nums, left, end);
        
    }
}
```
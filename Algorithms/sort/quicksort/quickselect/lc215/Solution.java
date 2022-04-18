package sort.quicksort.quickselect.lc215;
/* lc215. Kth Largest Element in an Array

 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }

        return selectK(nums, 0, nums.length - 1, k);

    }
    public int selectK(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        // 此处是和quick sort的区别，当上边while循环结束后，会出现两种情况：right和left指针之间没有数，也有可能right和left之间有一个数。(参考QuickSort第36行)
        if(left <= end - k + 1) {
            return selectK(nums, left, end, k);
        }
        if(right >= end - k + 1) {
            return selectK(nums, start, right, k - (end - right));
        }
        return nums[right + 1];
    }
}

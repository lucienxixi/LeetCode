package sort.mergesort.merge.lc88;
// lc88. Merge Sorted Array
// lintcode 6
// time complexity: O(m+n)
// space complexity: O(m+n)
import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];
        int j = 0; // index of nums1
        int k = 0; // index of nums2

        for (int i = 0; i < temp.length; i++) {
            if (j == m) {
                temp[i] = nums2[k];
                k++;
            } else if (k == n) {
                temp[i] = nums1[j];
                j++;
            } else if (nums1[j] <= nums2[k]) {
                temp[i] = nums1[j];
                j++;
            } else {
                temp[i] = nums2[k];
                k++;
            }
        }

        // copy temp into nums1
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums1 = {2,3,5,7,8,9,12,0,0,0,0,0};
        int [] nums2 = {2,4,5,6,10};
        int m = 7;
        int n = 5;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
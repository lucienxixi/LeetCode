package sort.mergesort.merge.lc88;

import java.util.Arrays;

// better solution, do it in place, no extra space is created
// time complexity: O(m+n)
// space complexity: O(1)
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = nums1.length - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }else if (p1 < 0) {
                nums1[p] = nums2[p2];
                p2--;
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
        }
    }
    public static void main(String[] args){
        Solution1 solution1 = new Solution1();
        int [] nums1 = {2,3,5,7,8,9,12,0,0,0,0,0};
        int [] nums2 = {2,4,5,6,10};
        int m = 7;
        int n = 5;
        solution1.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
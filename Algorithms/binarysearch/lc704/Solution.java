package binarysearch.lc704;
/*
lc704. Binary Search

前提是已经排序的数组，对于特殊的题目：有一定顺序的数组也可以进行二分如lintcode585
二分法模板写法

查询问题首先想到的是哈希表，查询的时间复杂度是O(1)，为什么不用呢？
缺点：会受到内存限制，哈希表是基于内存的，如果数据非常多，会存在无法导入内存的问题。数组虽然也是存在内存上的，但是我们可以将数据导入到磁盘(外存)，再
运用二分查找，时间复杂度O(logn)比O(1)稍大一些。

 */

public class Solution {

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        // 要点1: start + 1 < end 防止死循环，但最后要单独处理nums[start]和nums[end]
        while (start + 1 < end) {
            // 要点2：start + (end - start) / 2 防止因数字过大导致溢出(python不会)
            int mid = start + (end - start) / 2;
            // 要点3：=, <, > 分开讨论，mid 不+1也不-1
            if (nums[mid] == target) {
                start = mid; // find last position
//                end = mid; // find first position
            } else if (nums[mid] < target) {
                start = mid; // or start = mid + 1;
            } else {
                end = mid; // or end = mid - 1;
            }
        }

        // 要点4: 循环结束后，单独处理start和end

        // find last position
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;

        // find first position
//        if (nums[start] == target) {
//            return start;
//        }
//        if (nums[end] == target) {
//            return end;
//        }
//        return -1;

    }
}
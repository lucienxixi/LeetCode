package binarysearch.lc702;
/*
  lc702. Search in a Sorted Array of Unknown Size
  lintcode447. Search in a Big Sorted Array
 */
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

/*
class Solution {
    public int search(ArrayReader reader, int target) {
        int searchLength  = 1;
        while (reader.get(searchLength - 1) < target) {
            searchLength = searchLength * 2;
        }

        // int start = searchLength / 2;
        int start = 0;
        int end = searchLength - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}

 */
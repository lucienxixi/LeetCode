package sort.mergesort;
/* 未完成
 *题号：
  merge sort(while循环写法)
  lintcode463. Sort Integers

 *算法，数据结构, 解题思想：
  先局部有序，后整体有序
  merge，divide and conquer，recursion

 *复杂度分析：
  time complexity: O(nlogn)
  space complexity: O(n), an array need to be created
  稳定性：好于quicksort
 */

public class MergeSort {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int mid = (start + end) / 2;

        mergeSort(A, start, mid, temp);
        mergeSort(A, mid + 1, end, temp);
        merge(A, start, mid, end, temp);
    }

    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid + 1;
        int index = start;

        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }

        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }
}

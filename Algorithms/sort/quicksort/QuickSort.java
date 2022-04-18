package sort.quicksort;
/*
 *题号：
  quick sort(while循环写法)
  lintcode463. Sort Integers

 *算法，数据结构, 解题思想：
  先整体有序，后局部有序；
  partition -> 相向双指针, recursion, divide and conquer

  相向双指针：
  153266789
  ^       ^
  L       R

  partition思想：
  选取一个pivot，最好选取array中点所在的数：pivot = array[(start + end)/2]，使得数组中的数<=pivot的在左边，>=pivot的在右边。

  1. 为什么是使得数组中的数<=pivot的在左边，>=pivot的在右边?而不是<和>=或者<=和>？
  保证=pivot的情况均匀的分布在左边和右边，为了避免极端情况如：111111112，pivot极大概率是1，这样的partition会出现极不均匀的划分。如果partit-
  -ion不能保证尽可能的均分，有可能会出现worst case，时间复杂度会退化到O(n^2)。
  2. pivot的选取：
  在排好序的情况下，pivot选择array[end]或者array[start]，worst case, O(n^2)。
  调用random函数选取pivot，从选取结果上来说很理想，但是调用random函数会耗费空间和时间。

  partition过程：
  L和R指针相向移动(while循环1)
  L指针遇到>=pivot的停下否则继续移动L++(while循环2)
  之后R指针遇到<=pivot的停下来否则继续移动R--(while循环3)
  array[L]和array[R]交换位置，交换后L和R各种前进一位，L++，R--(if)
  当L超过R结束循环,L>R

  1. while循环1为什么是left <= right, 而不是 left < right？
  如果left < right，那就说明left >= right循环结束，可能存在left和right指向同一个数，往下递归的的时候，该数又在左边的数组也在右边的数组。当数
  组仅剩下两个数的时候，会出现stackoverflow。
  2. 循环结束left和right指针会出现两种情况
   (1)
   163256789    ->   153266789
   ^       ^            ^^
   L       R            RL
   (2)
   123456789    ->   1234[5]6789
   ^       ^            ^   ^
   L       R            R   L

 *复杂度分析：
  time complexity: O(nlogn)
  O(nlogn)指的是平均复杂度
  space complexity: O(1)
  in-place，原地排序不开辟额外空间
  稳定性：差于mergesort
 */


import java.util.Arrays;

public class QuickSort {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] array, int start, int end) {
        // recursion出口
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;

        // pivot选取数组中点所在的数
        int pivot = array[(start + end) / 2];

        // left <= right, not left < right
        while (left <= right) {
            //array[left] < pivot, 保证=pivot的情况在左右均匀分布避免极端情况; 因为每次left++，所以每次都要保证left <= right
            while (left <= right && array[left] < pivot) {
                left++;
            }
            //array[right] > pivot, 保证=pivot的情况在左右均匀分布避免极端情况; 因为每次right--，所以每次都要保证left <= right
            while (left <= right && array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        //这时left指针已经超过right指针，所以递归的时候是从start到right，left到end
        quickSort(array, start, right);
        quickSort(array, left, end);
    }


    public static void main (String[] args) {
        sort.quicksort.QuickSort solution  = new sort.quicksort.QuickSort();
        int[] nums = {-1,5,-2,0,7,-2,5,6,72,4,0};
        solution.sortIntegers(nums);
        System.out.println(Arrays.toString(nums));
    }
}
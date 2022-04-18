package twosum.lc1;
/*
   lc1. Two Sum
   lintcode56. Two Sum: 返回的indices需要从小到大其余和这题都一样。 返回的indices是否需要有序，注意34行的存入数组时的顺序即可。

   HashMap

   time complexity: O(n)
   each look up in the hash table only costs O(1)
   space complexity: O(n)
   the extra space required depends on the number of items stored in the hash table, which stores at most n elements.

   follow up:
   如果输入数组已经排序(lc167)，哪个算法更好？不论是返回数值还是下标，都是双指针的更优。时间复杂度都是O(n)，空间复杂度O(1)小于使用HashMap的O(n)。
   如果输入数组未排序需要返回所找到的两个数在数组中的下标(此题)，哪种算法更好？ 使用HashMap的方法好(此方法)。时间复杂度O(n)小于双指针的O(nlogn), 空间复杂度都是O(n)。
   如果输入数组未排序需要返回所找到的两个数的数值，哪种算法更好？HashMap时间复杂度O(n)，空间复杂度O(n)。双指针的时间复杂度O(nlogn)，空间复杂度O(1)。
 */


import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

    Map <Integer, Integer> hashmap = new HashMap <> ();

    for (int i = 0; i < nums.length; i++) {
        if (hashmap.containsKey(target - nums[i])) {
            int[] result = {hashmap.get(target - nums[i]), i};
            return result;
        }
        hashmap.put(nums[i], i);
    }
    int[] result = {};
    return result;
    }

    public static void main (String[] args) {
        twosum.lc1.Solution solution  = new twosum.lc1.Solution();
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(solution.twoSum(nums,9)));
    }
}
package twosum.lc167;
/*
  lc167. Two Sum II - Input array is sorted

  HashMap

  time complexity: O(n)
  each look up in the hash table only costs O(1)
  space complexity: O(n)
  the extra space required depends on the number of items stored in the hash table, which stores at most n elements.

  输入的数组是已排序的，所以双指针和哈希表的时间复杂度一样，但是双指针的空间复杂度是O(1)优于哈希表的O(n)。
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashmap.containsKey(target - nums[i])) {
                int[] result = {hashmap.get(target - nums[i]) + 1, i + 1};
                return result;
            }
            hashmap.put(nums[i], i);
        }
        int[] result = {};
        return result;
    }

    public static void main (String[] args) {
        twosum.lc167.Solution solution  = new twosum.lc167.Solution();
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(solution.twoSum(nums,9)));
    }
}
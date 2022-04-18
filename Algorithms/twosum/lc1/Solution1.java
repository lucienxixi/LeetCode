package twosum.lc1;
/* 未完成
   lc1. Two Sum

   先排序(java内置排序) —> 相向双指针

   time complexity: O(nlogn)
   space complexity: O(n)
   因为需要返回数组下标，数组排序之后，下标改变，因此需要存入原数组中的数及其下标一起排序从而花费O(n)的空间。
 */

import java.util.Arrays;

public class Solution1 {
    class Pair implements Comparable<Pair> {
        int number, index;

        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int compareTo(Pair other) {
            return number - other.number;
        }
    }
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};

        if (numbers == null) {
            return result;
        }

        Pair[] pairs = getSortedPairs(numbers);

        int left = 0, right = pairs.length - 1;
        while (left < right) {
            if (pairs[left].number + pairs[right].number < target) {
                left++;
            } else if (pairs[left].number + pairs[right].number > target) {
                right--;
            } else {
                result[0] = Math.min(pairs[left].index, pairs[right].index);
                result[1] = Math.max(pairs[left].index, pairs[right].index);
                return result;
            }
        }

        return result;
    }

    private Pair[] getSortedPairs(int[] numbers) {
        Pair[] pairs = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }
        Arrays.sort(pairs);

        return pairs;
    }
}

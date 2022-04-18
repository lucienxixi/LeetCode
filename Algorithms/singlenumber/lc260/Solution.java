package singlenumber.lc260;

import java.util.HashMap;
import java.util.Map;

/*
 lc260. Single Number III
 */

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int number : nums) {
            hashMap.put(number, hashMap.getOrDefault(number,0) + 1);
        }

        int[] result = new int[2];
        int index = 0;

        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key) == 1) {
                result[index] = key;
                index++;
            }
        }
        return result;
    }
}


package singlenumber.lc136;
/*
 lc136. Single Number
 */
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int number : nums) {
            a ^= number;
        }
        return a;
    }
}
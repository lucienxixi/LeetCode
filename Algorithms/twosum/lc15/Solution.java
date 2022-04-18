package twosum.lc15;
/*
   lc15. 3Sum
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> result1 = twoSum(nums, i + 1, nums.length - 1, -nums[i]);
            result.addAll(result1);
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int value) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = end;
        while (left < right) {
            if (nums[left] + nums[right] == value) {
                List <Integer> result1 = new ArrayList<>();
                result1.add(nums[start - 1]);
                result1.add(nums[left]);
                result1.add(nums[right]);
                result.add(result1);
                left++;
                right--;
                while (left < right && nums[left - 1] == nums[left]) {
                    left++;
                }
                while (left < right && nums[right + 1] == nums[right]) {
                    right++;
                }
            }
            if (nums[left] + nums[right] < value) {
                left++;
            }
            if (nums[left] + nums[right] > value) {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array= {-2,0,1,1,2};
        System.out.println(solution.threeSum(array));
    }
}
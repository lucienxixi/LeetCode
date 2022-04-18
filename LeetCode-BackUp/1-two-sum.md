```
class Solution { 
    public int[] twoSum(int[] nums, int target) {
        
    HashMap <Integer, Integer> hashmap = new HashMap<>();
        
    for (int i = 0; i < nums.length; i++) {
        if (hashmap.containsKey(target - nums[i])) {
            int[] result = {i, hashmap.get(target - nums[i])};
            return result;
        }
        hashmap.put(nums[i], i);
    }
        
    int[] result = {};
    return result;
        
    }
}
```

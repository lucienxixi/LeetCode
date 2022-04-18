```
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        int[] nums = createArray(n);
        dfs(nums, 0, k, new ArrayList<>(), results);
        return results;
    }
    
    private int[] createArray(int n) {
        int[] nums = new int[n];
        int num = 1;
        for (int i = 0; i < n; i++) {
            nums[i] = num;
            num++;
        }
        return nums;
    } 
    
    private void dfs(int[] nums, 
                     int startIndex, 
                     int k, 
                     List<Integer> combination, 
                     List<List<Integer>> results) {
        
        if (k == 0) {
            results.add(new ArrayList<>(combination));
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            combination.add(nums[i]);
            dfs(nums, i + 1, k - 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}

```
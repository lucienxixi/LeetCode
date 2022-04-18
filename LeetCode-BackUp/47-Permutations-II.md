```
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>(); 
        dfs(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }
    
    private void dfs (int[] nums, 
                      boolean[] visited, 
                      List<Integer> permutation, 
                      List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<>(permutation));
        }        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
```
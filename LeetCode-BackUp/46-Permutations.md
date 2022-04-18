```
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
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
            // return;
        }        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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
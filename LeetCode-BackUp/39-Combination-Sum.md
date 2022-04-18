```
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(int[] candidates,
                     int target,
                     int startIndex,
                     List<Integer> combination,
                     List<List<Integer>> results) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            results.add(new ArrayList<>(combination));
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            // if (target < candidates[i]) {
            //     break;
            // }
            combination.add(candidates[i]);
            // System.out.println(combination);// debug
            dfs(candidates, target - candidates[i], i, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}
```
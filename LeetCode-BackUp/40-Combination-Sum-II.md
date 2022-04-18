```
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if (i > 0 && candidates[i] == candidates[i - 1] && i > startIndex) {
                continue;
            }
            combination.add(candidates[i]);
            System.out.println(combination);
            dfs(candidates, target - candidates[i], i + 1, combination, results);
            combination.remove(combination.size() - 1);
        }
    }
}
```
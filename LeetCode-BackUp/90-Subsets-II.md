```
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }
    
    
    private void dfs(int[] nums,
                     int startIndex,
                     List<List<Integer>> result,
                     List<Integer> subset) {
        
        result.add(new ArrayList<>(subset));
        
        // 不用写递归的出口, 因为当startIndex == nums.length时候for循环不会执行
        // if (startIndex == nums.length) {
        //     return;
        // }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i !=0 && nums[i] == nums[i - 1] && i != startIndex) { // 使用此方法去重的前提是nums是sorted, 条件中的 ！= 都可以换成 >
                continue;
            }
            subset.add(nums[i]);
            dfs(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
         
    }
}



class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>(), new HashSet<>());
        return result;
    }
    
    
    private void dfs(int[] nums,
                     int startIndex,
                     List<List<Integer>> result,
                     List<Integer> subset,
                     Set<String> hashSet) {
        
        String string = "";
        for (int j = 0; j < subset.size(); j++) {
            string = string + subset.get(j);
        }
        if (!hashSet.contains(string)) {
            result.add(new ArrayList<>(subset));
            hashSet.add(string);
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, result, subset, hashSet);
            subset.remove(subset.size() - 1);
        }
    }
}



class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       if (nums == null) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>(), new HashSet<>());
        return result;
    }
    
    
    private void dfs(int[] nums,
                     int startIndex,
                     List<List<Integer>> result,
                     List<Integer> subset,
                     Set<List> hashSet) {
        
        if (!hashSet.contains(subset)) {
            result.add(new ArrayList<>(subset));
            hashSet.add(new ArrayList<>(subset));
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, i + 1, result, subset, hashSet);
            subset.remove(subset.size() - 1);
        }
    }
}

```
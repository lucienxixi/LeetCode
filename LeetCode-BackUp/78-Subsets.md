```
class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        //Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, result, new ArrayList<>());
        return result;
    }
    
    private void dfs(int[] nums,
                     int index,
                     List<List<Integer>> result,
                     List<Integer> subset) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        subset.add(nums[index]);
        dfs(nums, index + 1, result, subset);
        
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, result, subset);   
    }
}


// 此方法是dfs通用方法
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }
        //Arrays.sort(nums);
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
            subset.add(nums[i]);
            //System.out.println(subset);
            dfs(nums, i + 1, result, subset);
            subset.remove(subset.size() - 1);
        }
        
    }
    
}

```
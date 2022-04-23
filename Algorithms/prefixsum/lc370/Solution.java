// lc370. Range Addition

// brute force是自己第一次做的， prefixSum是看了solution后做的

// brute force
class Solution1 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            for (int i = update[0]; i < update[1] + 1; i++) {
                ans[i] += update[2];
            }
        }
        return ans;
    }
}


// prefixSum
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int[] update : updates) {
            ans[update[0]] += update[2];
            if (update[1] < ans.length - 1) {
                ans[update[1] + 1] -= update[2];
            }
        }
        
        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }
        
        return ans;
    }
}
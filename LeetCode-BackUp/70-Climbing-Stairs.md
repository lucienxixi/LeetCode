```
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        
        int[] dpTable = new int[n + 1];
        
        // base case
        dpTable[1] = 1;
        dpTable[2] = 2;
        
        // recurrence
        for (int i = 3; i < n + 1; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n];
    }
}
```
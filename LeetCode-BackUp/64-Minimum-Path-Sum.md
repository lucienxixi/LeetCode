```
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dpTable = new int[m][n];
        
        //base case
        dpTable[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            dpTable[i][0] = grid[i][0] + dpTable[i - 1][0];
        }
        
        for (int j = 1; j < n; j++) {
            dpTable[0][j] = grid[0][j] + dpTable[0][j - 1];
        }
        
        // recurrence
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpTable[i][j] = Math.min(grid[i][j] + dpTable[i][j - 1], grid[i][j] + dpTable[i - 1][j]);
            }
        }
        
        return dpTable[m - 1][n - 1];
    }
}
```
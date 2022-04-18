package dynamicprogramming.uniquepaths.lc63;
/*
  lc63. Unique Paths II

  dp: bottom-up, base case特殊处理
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dpTable = new int[m][n];


        // base case
        if (obstacleGrid[0][0] == 1) {
            dpTable[0][0] = 0;
        } else {
            dpTable[0][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || dpTable[i - 1][0] == 0) {
                dpTable[i][0] = 0;
            } else {
                dpTable[i][0] = 1;
            }

        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1 || dpTable[0][j - 1] == 0) {
                dpTable[0][j] = 0;
            } else {
                dpTable[0][j] = 1;
            }

        }


        // bottom-up
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dpTable[i][j] = 0;
                } else {
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - 1];
                }
            }
        }

        return dpTable[m - 1][n - 1];
    }
}
package dynamicprogramming.uniquepaths.lc62;
/*
  lc62. Unique Paths

  dp: bottom-up

  time:
  space:
 */
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dpTable = new int[m][n];

        // base case
        for (int i = 0; i < m; i++) {
            dpTable[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dpTable[0][j] = 1;
        }

        // bottom-up
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - 1];
            }
        }

        return dpTable[m - 1][n - 1];
    }


    public static void main(String[] args) {


    }
}

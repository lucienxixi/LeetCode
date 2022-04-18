package dynamicprogramming.lc118;
/*
  lc118. Pascal's Triangle
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        int[][] dpTable = new int[numRows][numRows + 1];
        // base case
        dpTable[0][1] = 1;
        List<Integer> result= new ArrayList<>();
        result.add(dpTable[0][1]);
        results.add(result);
        // recurrence
        for (int i = 1; i < numRows; i++) {
            result= new ArrayList<>();
            for (int j = 1; j < numRows + 1; j++) {
                dpTable[i][j] = dpTable[i - 1][j] + dpTable[i - 1][j - 1];
                if (dpTable[i][j] != 0) {
                    result.add(dpTable[i][j]);
                }
            }
            results.add(result);
        }
        return results;
    }
}
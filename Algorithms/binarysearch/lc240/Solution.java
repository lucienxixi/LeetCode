package binarysearch.lc240;
/*
  lc240. Search a 2D Matrix II
  lintcode38, 返回总个数，增加变量count记录个数即可
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i > -1 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
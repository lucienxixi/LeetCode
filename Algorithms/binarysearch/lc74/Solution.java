package binarysearch.lc74;
/*
  lc74. Search a 2D Matrix
  lintcode28
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lengthOfArray = matrix.length * matrix[0].length;
        boolean result = binarySearch(0, lengthOfArray - 1, matrix, target);
        return result;
    }

    private boolean binarySearch(int left, int right, int[][] matrix, int target) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        int i = getRowIndex(mid, matrix);
        int j = getColIndex(mid, matrix);

        if (matrix[i][j] < target) {
            return binarySearch(mid + 1, right, matrix, target);
        }
        if (matrix[i][j] > target) {
            return binarySearch(left, mid - 1, matrix, target);
        }
        return true;
    }

    private int getRowIndex (int index, int[][] matrix) {
        int rowIndex = index / matrix[0].length ;
        return rowIndex;
    }

    private int getColIndex (int index, int[][] matrix) {
        int colIndex = index % matrix[0].length;
        return colIndex;
    }
}
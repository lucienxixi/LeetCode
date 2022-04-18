```
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int number = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int j = c1; j <= c2; j++) {
                matrix[r1][j] = number;
                number++;
            }
            for (int i = r1 + 1; i <= r2; i++) {
                matrix[i][c2] = number;
                number++;
            }
            if (r1 == r2 || c1 == c2) {
                break;
            }
            for (int j = c2 - 1; j >= c1; j--) {
                matrix[r2][j] = number;
                number++;
            }
            for (int i = r2 - 1; i > r1; i--) {
                matrix[i][c1] = number;
                number++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return matrix;
    }
}
```
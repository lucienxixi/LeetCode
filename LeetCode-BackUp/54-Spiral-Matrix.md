```
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<> ();
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (c1 <= c2 && r1 <= r2) {
            for (int j = c1; j <= c2; j++) {
                answer.add(matrix[r1][j]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                answer.add(matrix[i][c2]);
            }
            if (r1 == r2 || c1 == c2) {
                break;
            }
            for (int j = c2 - 1; j >= c1; j--) {
                answer.add(matrix[r2][j]);
            }
            for (int i = r2 - 1; i > r1; i--) {
                answer.add(matrix[i][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return answer;
    }
}
```
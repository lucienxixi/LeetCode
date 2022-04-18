```
// solved by myself
// 思路简单，但是代码不好写。
class Solution {
    public void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        
        while (start < end) {
            int i1 = start;
            int j1 = start;
            int i2 = start;
            int j2 = end;
            int i3 = end;
            int j3 = end;
            int i4 = end;
            int j4 = start;
        
            for (int i = start; i < end; i++) {
                int temp = matrix[i1][j1];
                matrix[i1][j1] = matrix[i4][j4];
                matrix[i4][j4] = matrix[i3][j3];
                matrix[i3][j3] = matrix[i2][j2];
                matrix[i2][j2] = temp;
                j1++;
                i2++;
                j3--;
                i4--;
            }
    
            start++;
            end--;
        }
    }
}
```
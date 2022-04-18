package dynamicprogramming.lc120;
/*
  lc120. Triangle
  lintcode109. Triangle, 函数参数是二维数组，leetcode是ArrayList

  DFS: divide and conquer
 */
import java.util.*;
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return divideConquer(triangle, 0, 0);
    }

    private int divideConquer(List<List<Integer>> triangle, int x, int y) {
        if (x == triangle.size()) {
            return 0;
        }

        int left = divideConquer(triangle, x + 1, y);
        int right = divideConquer(triangle, x + 1, y + 1);

        return Math.min(left, right) + triangle.get(x).get(y);
    }
}

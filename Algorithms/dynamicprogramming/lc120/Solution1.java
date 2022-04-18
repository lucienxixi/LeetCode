package dynamicprogramming.lc120;
/*
  lc120. Triangle
  lintcode109. Triangle, 函数参数是二维数组，leetcode是ArrayList

  Memoization
 */


import java.util.*;
class Solution1 {

    public int minimumTotal(List<List<Integer>> triangle) {
        return divideConquer(triangle, 0, 0, new HashMap<>());
    }

    private int divideConquer(List<List<Integer>> triangle, int x, int y, Map<String, Integer> hashMap) {
        String params = x + "," + y;

        if (x == triangle.size()) {
            return 0;
        }

        if (hashMap.containsKey(params)) {
            return hashMap.get(params);
        }

        int left = divideConquer(triangle, x + 1, y, hashMap);
        int right = divideConquer(triangle, x + 1, y + 1, hashMap);

        hashMap.put(params, Math.min(left, right) + triangle.get(x).get(y));
        return hashMap.get(params);
    }
}
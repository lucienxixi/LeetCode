package graph.bfs.lc547;
/*
  lc547. Number of Provinces
  lintcode1179. Friend Circles

  BFS, 二维数组
 */

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int findCircleNum(int[][] isConnected) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> hashSet = new HashSet<>();
        int numOfProv = 0;


        for (int i = 0; i < isConnected.length; i++) {
            if (!hashSet.contains(i + 1)) {

                queue.offer(i + 1);
                hashSet.add(i + 1);


                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int n = queue.poll() - 1;
                        for (int k = 0; k < isConnected[n].length; k++) {
                            if (n == k) {
                                continue;
                            } else if (isConnected[n][k] == 1 && !hashSet.contains(k + 1)) {
                                queue.offer(k + 1);
                                hashSet.add(k + 1);
                            }
                        }
                    }
                }
                numOfProv++;
            }
        }
        return numOfProv;
    }
}
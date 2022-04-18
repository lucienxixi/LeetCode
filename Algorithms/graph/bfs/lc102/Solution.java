package graph.bfs.lc102;
/*
lc102. Binary Tree Level Order Traversal

implement: one queue (推荐!)

单队列思路：
创建一个queue(ArrayDeque优于LinkedList)。
将起始点压入queue。
不断的将需要explore的node压入队列，将explore过的node推出队列，直到队列为空=每个node都explore完成，退出循环(while)：
    取出目前队列的size，作为循环次数。
    遍历当前队列中的每个node(for)：(循环size次，size=当前队列中node个数=二叉树当前层的node个数)
        取出当前层的node。
        explore:寻找下一层的子node将其压入队列，因为是二叉树，每个node最多连接两个子node，所以不需要内层循环。只需要两个if语句判断每个node左
        边，和右边是否有子node即可，有的话则压入队列。
    (结束for循环，现在队列里存放的是下一层，即将explore的node。)

 */


import graph.bfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        //List result = new ArrayList();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            // 要先把queue的size取出来，因为在for循环中size会变化。
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
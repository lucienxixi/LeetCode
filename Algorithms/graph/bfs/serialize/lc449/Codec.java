package graph.bfs.serialize.lc449;

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
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<TreeNode> arrayList = new ArrayList<TreeNode>();
        arrayList.add(root);
        while (!queue.isEmpty()) {
            TreeNode headNode = queue.poll();
            if (headNode != null) {
                arrayList.add(headNode.left);
                arrayList.add(headNode.right);
                queue.offer(headNode.left);
                queue.offer(headNode.right);
            }
        }
        return listToString(arrayList);
    }

    private String listToString(List<TreeNode> arrayList) {
        String string = "";
        for (TreeNode node : arrayList) {
            if (node == null) {
                string = string + "#" + ",";
            } else {
                string = string + node.val + ",";
            }
        }
        string = "[" + string + "]";
        return string;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] values = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        List<TreeNode> arrayList = new ArrayList<TreeNode>();
        arrayList.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < values.length; i++) {
            if (!values[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                if (isLeftChild) {
                    arrayList.get(index).left = node;
                } else {
                    arrayList.get(index).right = node;
                }
                arrayList.add(node);
            }

            if (!isLeftChild) {
                index++;
            }

            isLeftChild = !isLeftChild;
        }
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
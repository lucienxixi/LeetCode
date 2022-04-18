package graph.bfs.lc133;
/*
  lc133. Clone Graph
  lintcode137. Clone Graph

  BFS, 引用，deep copy

  time complexity：O(n+m)
  space complexity：O(n)
 */

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        //BFS: find all nodes and store these in the ArrayList
        List<Node> nodesList = findNodes(node);

        //copy all nodes into the HashMap
        Map<Node, Node> nodesMap = copyNodes(node, nodesList);

        //copy all edges(neighbors)
        copyEdges(nodesList, nodesMap);

        return nodesMap.get(node);
    }

    private List<Node> findNodes(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> hashSet = new HashSet<>();

        queue.offer(node);
        hashSet.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            for (Node neighbors : node.neighbors) {
                if (!hashSet.contains(neighbors)) {
                    queue.offer(neighbors);
                    hashSet.add(neighbors);
                }
            }
        }

//        List<Node> nodesList = new ArrayList<>();
//        for (Node node1 : hashSet) {
//            nodesList.add(node1);
//        }
        // ArrayList其中一个构造函数可以直接传入集合。
        List<Node> nodesList = new ArrayList<>(hashSet);
        return nodesList;
    }

    private Map<Node, Node> copyNodes(Node node, List<Node> nodesList) {
        Map<Node, Node> nodesMap = new HashMap<>();
        for (Node node1 : nodesList) {
            nodesMap.put(node1, new Node(node1.val));
        }
        return nodesMap;
    }

    private void copyEdges(List<Node> nodesList, Map<Node, Node> nodesMap) {
        for (Node node : nodesList) {
            Node newNode = nodesMap.get(node);
            for(Node neighbor : node.neighbors) {
                Node newNeighbors = nodesMap.get(neighbor);
                newNode.neighbors.add(newNeighbors);
            }
        }
    }

    public static void main(String[] args) {
        List<Node> neighbors = new ArrayList<>();
        neighbors.add(new Node(2));
        neighbors.add(new Node(3));
        Node node = new Node(1, (ArrayList<Node>) neighbors);

        Solution solution1 = new Solution();
        Node newNode = solution1.cloneGraph(node);
        System.out.println(newNode.val);
    }
}
















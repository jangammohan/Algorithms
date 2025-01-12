package com.example.october;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeSubTreeRemoval_2458 {

    private Map<Integer, Integer> heightMap = new HashMap<>();
    // Map to store the maximum heights for each node (used for efficient query processing)
    private Map<Integer, int[]> maxHeightsMap = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        int result[] = new int[queries.length];


        heightTree(root);

        dfs(root, 0, 0);

        for(int i =0 ; i < queries.length;i++) {
            result[i] = maxHeightsMap.get(queries[i])[1];
        }

        return result;
    }

    private int heightTree(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int left = heightTree(root.left);
        int right = heightTree(root.right);

        int maxHeight = 1+ Math.max(left, right);
        heightMap.put(root.val, maxHeight);

        return maxHeight;
    }

    private void dfs(TreeNode node, int depth, int currenMax) {
        if(node == null) {
            return;
        }
        int[] maxHeights = maxHeightsMap.getOrDefault(node.val, new int[]{-1,-1});
        maxHeights[0] = depth;
        maxHeights[1] = currenMax;
        maxHeightsMap.put(node.val, maxHeights);
        if (node.left != null) {
            int siblingHeight = node.right == null ? -1 : heightMap.get(node.right.val);
            int newParentHeight = Math.max(currenMax, depth + siblingHeight + 1);
            dfs(node.left, depth + 1, newParentHeight);
        }
        if (node.right != null) {
            int siblingHeight = node.left == null ? -1 : heightMap.get(node.left.val);
            int newParentHeight = Math.max(currenMax, depth + siblingHeight + 1);
            dfs(node.right, depth + 1, newParentHeight);
        }
    }
}

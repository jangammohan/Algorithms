package com.example.algorithms.medium.BFS;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeInfected {
        int weightIndex =0;
    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode nine = new TreeNode(9);
        TreeNode four = new TreeNode(4, nine, two);
        TreeNode five = new TreeNode(5, null, four);
        TreeNode ten = new TreeNode(10);
        TreeNode six = new TreeNode(6);
        TreeNode three = new TreeNode(3, ten, six);
        TreeNode one = new TreeNode(1, five, three);

        BinaryTreeInfected infected = new BinaryTreeInfected();

        System.out.println(infected.amountOfTime(one, 3));

    }

    public int amountOfTime(TreeNode root, int start) {
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        int leftIndex = getTreeIndex(root.left, leftSet);
        int rightIndex = getTreeIndex(root.right, rightSet);

        if(root.val == start) {
            return Math.max(leftIndex, rightIndex);
        }

        int result =0;
        if(leftSet.contains(start)) {
           findWeightedValue(root.left, 0, start);
           result = rightIndex+ (weightIndex-1+ leftIndex-weightIndex);
        } else if(rightSet.contains(start)) {
            findWeightedValue(root.right, 0, start);
            result = leftIndex+ (weightIndex-1+ rightIndex-weightIndex);
        }

        return result;
    }

    public void findWeightedValue(TreeNode node, int count, int start) {

        if(node == null ){
            return;
        }
        if(node.val == start ) {
            weightIndex =count;
        }
        findWeightedValue(node.left, count+1, start);
        findWeightedValue(node.right, count+1, start);
    }

    public int getTreeIndex(TreeNode node, Set<Integer> set) {

        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            return 1;
        }
        set.add(node.val);
        return 1+Math.max(getTreeIndex(node.left, set), getTreeIndex(node.right, set));
    }
}

package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BinaryTreeLeaves {

    public static void main(String[] args) {
        TreeNode  four = new TreeNode(4);
        TreeNode  five = new TreeNode(5);
        TreeNode  two = new TreeNode(2,four, five);
        TreeNode  three = new TreeNode(3);
        TreeNode  treeNode = new TreeNode(1, two,three);



        List<List<Integer>> result =  findLeaves(treeNode);
        result.stream().forEach(a-> System.out.println(a));
    }

    public static List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> ls = new ArrayList<>();

        while(root!= null) {
            List<Integer> temp = new ArrayList<>();
            root = findLeavesLevels(root, temp);
            ls.add(temp);
        }

        return ls;
    }

    public static TreeNode findLeavesLevels(TreeNode root, List<Integer> temp) {

        if(root == null) {
            return null;
        }

        if(root.left == null && root.right == null) {
                temp.add(root.val);
            return null;
        }

        root.left = findLeavesLevels(root.left, temp);

        root.right = findLeavesLevels(root.right, temp);

        return root;

    }
}

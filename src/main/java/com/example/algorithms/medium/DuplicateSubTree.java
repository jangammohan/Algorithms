package com.example.algorithms.medium;

import java.util.*;

public class DuplicateSubTree {


    public static void main(String[] args) {

        TreeNode four = new TreeNode(4);
        TreeNode two = new TreeNode(2,four,null);

        TreeNode dupfour = new TreeNode(4);
        TreeNode duptwo = new TreeNode(2,four,null);


        TreeNode rightFour = new TreeNode(4);
        TreeNode three = new TreeNode(3, duptwo, rightFour);

        TreeNode one = new TreeNode(1, two,three);
        findDuplicateSubtrees(one);
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> treeMap = new HashMap<>();


        findDupSubtrees(root, result, treeMap);
        System.out.println("Result: "+result);
        return result;
    }

    public static String  findDupSubtrees(TreeNode root, List<TreeNode> result,  Map<String, Integer> treeMap) {

        if (root == null ){
            return "N";
        }

        String left = findDupSubtrees(root.left, result, treeMap);

        String right = findDupSubtrees(root.right, result, treeMap);

        String current = root.val+" "+left+" "+right;

        treeMap.put(current, treeMap.getOrDefault(current, 0)+1);
        if(treeMap.get(current) == 2) {
            result.add(root);
        }

       return current;

    }

    public static boolean findSubTree(TreeNode node, Set<Integer> treeMap) {

        if(node == null) {
            return true;
        }

        if(!treeMap.contains(node.val)) {
            return false;
        }
        return findSubTree(node.left, treeMap) && findSubTree(node.right, treeMap);
    }
}

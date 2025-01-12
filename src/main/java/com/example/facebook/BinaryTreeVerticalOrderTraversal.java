package com.example.facebook;


import java.util.*;


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

public class BinaryTreeVerticalOrderTraversal {

    int min =0;
    int max =0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        for(int i = min; i<=max;i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public void verticalOrder(TreeNode root, int index, Map<Integer, List> map) {
        if(root == null) {
            return;
        }
        map.computeIfAbsent(index,(key)-> new ArrayList<>());
        map.get(index).add(root.val);
        min = Math.min(min, index);
        max = Math.max(max, index);
        verticalOrder(root.left,index-1,map);
        verticalOrder(root.right, index+1,map);
    }


    public List<List<Integer>> leetSolution(TreeNode node) {

        if(node == null){
            return null;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> tree = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        tree.add(node);
        cols.add(0);
        int min =0, max =0;

        while(!tree.isEmpty()) {

            int col = cols.poll();
            TreeNode currentNode = tree.poll();

            map.computeIfAbsent(col, key-> new ArrayList<>() );
            map.get(col).add(currentNode.val);

            if(currentNode.left!= null) {
                tree.add(currentNode.left);
                cols.add(col-1);
                min = Math.min(min, col);
            }

            if(currentNode.right != null) {
                tree.add(currentNode.right);
                cols.add(col+1);
                max= Math.max(max, col);
            }


        }

        for(int i = min; i<=max;i++) {
            result.add(map.get(i));
        }

        return result;

    }
}

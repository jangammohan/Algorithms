package com.example.Top150.arrays;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}

public class LeastCommonAncestorOfBinaryTree {
    public static void main(String[] args) {

    }

//LCA with two Nodes.
    public Node lowestCommonAncestor(Node p, Node q) {


        if(p.parent == q.parent) {
            return p.parent;
        }

        Set<Integer> set = new HashSet<>();
        set.add(p.val);
        set.add(q.val);

        Node root = null;
        while(p.parent != null) {
            p = p.parent;
        }
        root = p;



        return null;
    }

    public Node LCA(Node root, Set<Integer> set) {

        if(root == null) {
            return null;
        }
        if(set.contains(root.val)) {
            return root;
        }

        Node left = LCA(root.left, set);
        Node right = LCA(root.right, set);

        if(left == right){
            return null;
        }
        else if(left != right){
            return root;
        }
        else if(left == null){
            return right;
        }else {
            return left;
        }
    }

// LCA with list of nodes

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        Set<Integer> values = new HashSet<>();

        for(TreeNode node : nodes) {
            values.add(node.val);
        }


        return lowestCommonAncestor(root, values);
    }

    public TreeNode lowestCommonAncestor(TreeNode root,  Set<Integer> values) {

        if(root == null){
            return null;
        }
        if(values.contains(root.val)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,values);
        TreeNode right = lowestCommonAncestor(root.right, values);

        if(left == right)
            return null;
        else if(left!= null && right!= null ) {
            return root;
        }else if(right == null){
            return left;
        }else
            return right;

    }
}

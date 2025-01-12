package com.example.facebook;

public class LeastCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if(root == null) {
            return null;
        }

        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left  = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == right){
            return null;
        }
        else if(left!= null && right!= null) {
            return root;
        } else if(left == null){
            return right;
        }else {
            return left;
        }


    }
}

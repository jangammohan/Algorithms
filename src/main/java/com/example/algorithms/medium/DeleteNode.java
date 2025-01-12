package com.example.algorithms.medium;


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
public class DeleteNode {

     public static void main(String args[]) {

         TreeNode four = new TreeNode(4);
         TreeNode five = new TreeNode(5);
         TreeNode leftNode = new TreeNode(2, four,five);
         TreeNode six = new TreeNode(6);
         TreeNode seven = new TreeNode(7);
         TreeNode rightNode = new TreeNode(3, six, seven);

         TreeNode rootNode = new TreeNode(1, leftNode, rightNode);

         DeleteNode dn = new DeleteNode();
         int[] toDel = {3,5};
         dn.delNodes(rootNode, toDel);
     }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

         List<TreeNode> result = new LinkedList<>();

        Set<Integer> hashMap = new HashSet<>();

        for(int a: to_delete) {
            hashMap.add(a);
        }

       TreeNode node =  treeTraversal(root, result, hashMap);

        if(!hashMap.contains(root.val)) {
            result.add(node);
        }

       result.forEach( (t) -> System.out.print(t.val+"\t") );

         return result;

    }

    public TreeNode treeTraversal(TreeNode root, List<TreeNode> result, Set<Integer> hashMap ) {


         if(root == null ) {
             return null ;
         }

         root.left = treeTraversal(root.left, result, hashMap);
         root.right = treeTraversal(root.right, result, hashMap);

         if(hashMap.contains(root.val)) {
             if(root.left != null)
                 result.add(root.left);
             if(root.right != null)
                 result.add(root.right);
            return null;
         }

         return root;

    }
}

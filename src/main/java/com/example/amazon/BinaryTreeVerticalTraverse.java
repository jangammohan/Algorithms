package com.example.amazon;

import java.util.*;
import java.util.stream.Collectors;

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

public class BinaryTreeVerticalTraverse {

    List<List<Integer>> result = new ArrayList<>();
    static Map<Integer, List<Integer>> resultMap = new TreeMap<>();

    public static void main(String[] args) {
// [3,9,8,4,0,1,7,null,null,null,2,5]
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode zero = new TreeNode(0, five, null);
        TreeNode nine = new TreeNode(9, four,zero);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1, null, two);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8, one, seven);

        TreeNode three = new TreeNode(3, nine, eight);

        //verticalOrder(three, 0);

        verticalOrderQueue(three);

        List<List<Integer>> result = resultMap.values().stream().collect(Collectors.toList());

        result.forEach( entry -> System.out.print(entry) );
    }

    public static void  verticalOrder(TreeNode root, int level) {

        if(root == null ) {
            return ;
        }


        if(resultMap.get(level) == null) {
            List<Integer> ls = new ArrayList<>();
            ls.add(root.val);
            resultMap.put(level, ls);
        } else {
            resultMap.get(level).add(root.val);
        }
         verticalOrder(root.left, level -1);


        verticalOrder(root.right, level+1);


    }

    public static void  verticalOrderQueue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList();

        queue.add(root);
        Queue<Integer> cols = new LinkedList<>();
        cols.add(0);
            while(!queue.isEmpty()) {
                TreeNode current = queue.poll();
                Integer level = cols.poll();
                if(resultMap.get(level) == null) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(root.val);
                    resultMap.put(level, ls);
                } else {
                    resultMap.get(level).add(current.val);
                }

                if(current.left != null) {
                    queue.add(current.left);
                    cols.add(level-1);
                }
                if(current.right != null) {
                    queue.add(current.right);
                    cols.add(level+1);
                }


            }
        }



}

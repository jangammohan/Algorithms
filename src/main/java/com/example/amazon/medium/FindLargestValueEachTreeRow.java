package com.example.amazon.medium;

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

public class FindLargestValueEachTreeRow {
    Map<Integer, Integer> result = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode five = new TreeNode(5) ;
        TreeNode three = new TreeNode(3) ;
        TreeNode rootThree = new TreeNode(3, five, three ) ;
        TreeNode nine = new TreeNode(9 ) ;
        TreeNode two = new TreeNode(2, null, nine ) ;
        TreeNode root = new TreeNode(1, rootThree, two ) ;
        FindLargestValueEachTreeRow obj = new FindLargestValueEachTreeRow();

        obj.largestValues(root, 0, obj.list);
        System.out.println(new ArrayList<Integer>(obj.result.values()));
        System.out.println(obj.list);
    }

    public  void largestValues(TreeNode root, int index, List<Integer> ls) {

        if(root == null) {
            return ;
        }
        if(index == ls.size()) {
            ls.add(root.val);
        }
        ls.set(index, Math.max(ls.get(index), root.val));
        largestValues(root.left, index+1,ls);
        largestValues(root.right, index+1, ls);

        result.computeIfAbsent(index, (key) -> root.val);
        result.computeIfPresent(index, (key, val) -> Math.max(val, root.val));


    }
}

package com.example.August.BFS;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class BinaryTreeRightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        if(root == null) {
            return new ArrayList<>();
        }
        rightSide(root, 0, map);
        return new ArrayList<>(map.values());

    }

    public void rightSide(TreeNode root, int level, Map<Integer, Integer> map) {
        if(root == null) {
            return;
        }

        map.put(level, root.val);

        rightSide(root.left, level+1, map );

        rightSide(root.right, level+1, map );

    }
}

package com.example.August.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ls = new ArrayList<>();
            for(int i =0 ;i < size; i++) {
                TreeNode temp = queue.poll();
                    ls.add(temp.val);
                    if(temp.left != null) {
                        queue.add(temp.left);
                    }
                    if(temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            result.add(ls);
        }

        return result;
    }
}

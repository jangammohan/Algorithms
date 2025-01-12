package com.example.facebook;

import java.util.*;

public class VerticalTraversalOftree {
    int min = 0;
    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        traversal(root, min, map);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = map.size(); i>0; i--) {
            Collections.sort(map.get(min), (a, b) -> b.compareTo(a));
            result.add(map.get(min));
            this.min++;
        }
        map.forEach((key, val)-> result.add(val));
        result.forEach(System.out::print);
        return result;
    }

    public void traversal(TreeNode node, int index, Map<Integer, List<Integer>> map) {

        if(node == null){
            return;
        }
        this.min = Math.min(index, min);
        map.computeIfAbsent(index, (key)-> new ArrayList<>()).add(node.val);

        traversal(node.left, index-1, map);
        traversal(node.right, index+1, map);

    }
}

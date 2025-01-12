package com.example.August.BFS;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafPair {

    public int countPairs(TreeNode root, int distance) {
        int sum[] = new int[1];

        dfs(root, sum, distance);

        return sum[0];

    }

    public List<Integer> dfs(TreeNode root, int[] sum, int distance) {

        if(root == null ){
            return new ArrayList<>();
        }

        if(root.left == null && root.right == null) {
            List ls = new ArrayList();
            ls.add(1);
            return ls;
        }

        List<Integer> left = dfs(root.left, sum, distance);
        List<Integer> right = dfs(root.right, sum, distance);
        List fin = new ArrayList<>();
        for(int i =0 ; i < left.size(); i++) {
            for(int j=0; j< right.size(); j++){
                if(left.get(i) + right.get(j) <= distance) {
                    sum[0]++;
                }
            }
        }

       for (int i =0; i< left.size(); i++) {
           if(left.get(i) <= distance) {
               fin.add(1+left.get(i));
           }
       }

        for (int i =0; i< right.size(); i++) {
            if(right.get(i) <= distance) {
                fin.add(1+right.get(i));
            }
        }
        return fin;
    }
}

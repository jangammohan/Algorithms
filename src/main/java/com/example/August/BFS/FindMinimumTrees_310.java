package com.example.August.BFS;

import java.util.*;

public class FindMinimumTrees_310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();



        if(edges.length == 0) {


            return Collections.singletonList(0);
        }



        int[] ind = new int[n];

        for (int[] edge : edges) {
                ind[edge[0]]++;
                ind[edge[1]]++;
           // int key = map.get(edge[0]) == null ? (map.get(edge[1]) == null ? edge[0] : edge[1] ) : edge[0];
            map.computeIfAbsent(edge[0], (k)-> new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1], (k)->new ArrayList<Integer>() ).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i =0; i<n;i++) {
            if(ind[i] == 1) {
               queue.add(i);
            }
        }

       int remNodes = n;

        while(remNodes > 2) {
            int size = queue.size();
            remNodes-= size;
            for(int i =0 ; i < size; i++) {
                int node = queue.poll();
                for(int val : map.get(node)) {
                    if(--ind[val] == 1) {
                        queue.add(val);
                    }
                }
            }
        }

        return new ArrayList<>(queue);

    }
}

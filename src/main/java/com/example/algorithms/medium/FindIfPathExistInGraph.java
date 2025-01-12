package com.example.algorithms.medium;

import java.util.*;

public class FindIfPathExistInGraph {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {2,0}};

        System.out.println(validPath(3, edges, 0, 2));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) {
            return true;
        }

        if(edges.length == 0){
            return false;
        }

        Map<Integer, List<Integer>> relations = new HashMap<>();

        for(int[] edge : edges) {
            relations.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
        }

        if(relations.get(source) == null) {
            return false;
        }else {

            Queue<List<Integer>> queue = new LinkedList<>();
            queue.add(relations.get(source));

            while (queue.size() > 0) {

                if (queue.peek().contains(destination)) {
                    return true;

                }

                List<Integer> temp = queue.poll();

                    for (Integer a : temp) {
                        if(relations.get(a) != null) {
                            queue.add(relations.get(a));
                        }
                    }


            }
        }

        return false;
    }
}

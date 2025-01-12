package com.example.google.interview;

import java.util.*;

public class ShortestPath {

    int shortest = Integer.MAX_VALUE;
    Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        int a[][] = {{1,2}, {2,3},{1,3}, {3,4}};

        int src = 2, dest =4;

        Map<Integer, List<Integer>> connectedMap = new HashMap<>();
        for(int temp[] : a) {
            connectedMap.computeIfAbsent(temp[0],key -> new ArrayList<>()).add(temp[1]);

        }

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{src, 0});

        Set<Integer> set = new HashSet<>();
        while(!queue.isEmpty()) {

            int curr[] = queue.poll();
            int curPoint = curr[0];
            int distance = curr[1];

            if(curPoint == dest) {
                System.out.println(distance);
                break;
            }
            for(Integer conPoint : connectedMap.get(curPoint) ) {

                if(!set.contains(conPoint) ) {
                    queue.offer(new int[]{conPoint, distance+1});
                    set.add(conPoint);
                }
            }

        }
    }


    public void DFS(Map<Integer, List<Integer>> connectedMap, int src, int end, int distance  ) {

        if(src == distance) {
            shortest = Math.min(shortest, distance);
            return ;
        }


        for(Integer a : connectedMap.get(src)) {
           if(!set.contains(a)) {
               set.add(a);
                DFS(connectedMap, a, end, distance+1);
               set.remove(a);
           }
        }
    }
}

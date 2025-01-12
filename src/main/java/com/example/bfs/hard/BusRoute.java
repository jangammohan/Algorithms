package com.example.bfs.hard;

import java.util.*;

public class BusRoute {
    public int numBusesToDestination(int[][] routes, int source, int target) {

        HashMap<Integer, List<Integer>> busRoute = new HashMap<>();

        Set<Integer> visited = new HashSet();

        Queue<Integer> queue = new ArrayDeque<>();
        int result = 0;

        if(source == target) {
            return 0;
        }



        for(int i =0 ; i<routes.length;i++) {
            for(int j=0; j<routes[i].length; j++) {
                List list =  busRoute.getOrDefault(routes[i][j], new ArrayList<>());
                list.add(i);
                busRoute.put(routes[i][j], list);
            }
        }

        if(busRoute.get(source) == null) {
            return -1;
        }

        queue.offer(source);



        while(!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for(int i =0 ; i<size; i++) {
                int curr = queue.poll();
                List<Integer> buses = busRoute.get(curr);
                for(int bus : buses) {
                    if(visited.contains(bus)) {
                        continue;
                    }
                    visited.add(bus);
                    for(int k =0 ; k<routes[bus].length;k++) {
                        if(routes[bus][k] == target) {
                            return result;
                        }
                        queue.offer(routes[bus][k]);
                    }



                }
            }
        }

        return -1;
    }
}


package com.example.november;

import java.util.*;

public class ShortestDistance_3243 {

    public static void main(String[] args) {
        ShortestDistance_3243 shortest = new ShortestDistance_3243();
        int[] ans = shortest.shortestDistanceAfterQueriesLeet(6, new int[][]{{1,4},{0,2}});
        Arrays.stream(ans).forEach(System.out::println);
    }

    //ChatGpt Solution fails for some uses cases, but good example
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] res = new int[queries.length];

        // Map to store jumps
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int[] temp = queries[i];

            // Update map to point to the farthest reachable position
            map.put(temp[0], Math.max(map.getOrDefault(temp[0], temp[0]), temp[1]));

            int step = 0;
            int current = 0;

            // Traverse from start to the end
            while (current < n - 1) {
                // If a jump exists, use it
                if (map.containsKey(current)) {
                    current = map.get(current);
                } else {
                    // Otherwise, move forward step by step
                    current++;
                }
                step++;
            }

            res[i] = step;
        }

        return res;
    }


    //leetcode using BFS

    public int[] shortestDistanceAfterQueriesLeet(int n, int[][] queries) {
        List<List<Integer>> list = new ArrayList<>();
        int res[] = new int[queries.length];

        for(int i = 0 ;i<n; i++) {
            list.add(new ArrayList<>());
            if(i!=0){
                list.get(i-1).add(i);
            }

        }

        int i =0 ;
        for(int[] query : queries) {
            list.get(query[0]).add(query[1]);
            res[i++] = BFS(list, n);

        }
        return res;
    }

    private int BFS(List<List<Integer>> list, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int count =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0; k<size; k++) {

                int temp = queue.poll();

                if(temp == n-1) {
                    return count;

                }
                List<Integer> tempList = list.get(temp);
                for(int j : tempList) {
                    if(!visited[j])
                    {queue.add(j);
                        visited[j] = true; }
                }

            }

            count++;
        }
        return -1;
    }
}

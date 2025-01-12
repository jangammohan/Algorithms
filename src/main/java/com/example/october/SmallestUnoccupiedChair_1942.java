package com.example.october;

import java.util.*;

public class SmallestUnoccupiedChair_1942 {
    public static void main(String[] args) {
        SmallestUnoccupiedChair_1942 small = new SmallestUnoccupiedChair_1942();
        System.out.println(small.smallestChair(new int[][]{{3,10},{1,5},{2,6}}, 0));
    }

    public int smallestChair(int[][] times, int targetFriend) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(( a, b) -> a[1] - b[1]);
        TreeSet<Integer> set = new TreeSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        int index =0;
        for(int[] time: times) {
            queue.add(new int[]{index, time[0], time[1]});
            set.add(index++);
        }

        int startTime =1;
        while(!queue.isEmpty()) {

            int curr[] = queue.peek();

            if(map.get(startTime) != null) {
                for(int val : map.get(startTime)) {
                    set.add(val);
                }
                map.remove(startTime);
            }

            if(curr[1] == startTime) {
                int chair =set.pollFirst();

                if(curr[0] == targetFriend){
                    return chair;
                }
                List<Integer> temp =map.getOrDefault(curr[2], new ArrayList<>());
                temp.add(chair);
                map.put(curr[2] ,temp);
                queue.poll();
            }
            startTime++;
        }

        return -1;
    }
}

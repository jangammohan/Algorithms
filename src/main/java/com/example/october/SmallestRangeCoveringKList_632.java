package com.example.october;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringKList_632 {

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int max = Integer.MIN_VALUE;
        int start =0;
        int range = Integer.MAX_VALUE;
        for(int i =0 ; i<nums.size(); i++) {

            queue.offer(new int[]{nums.get(i).get(0), i, 0 });
            max = Integer.max(max, nums.get(i).get(0));
        }
        int end = max;
        while(nums.size() == queue.size()) {

            int[] temp = queue.poll();
            int row = temp[1];
            int col = temp[2];
            if(end - start < range) {
                start = temp[0];
                range = max - start;
                end = max;
            }

            if(col+1 < nums.get(row).size()) {
                queue.offer(new int[]{nums.get(row).get(col+1), row, col+1});
                max = Integer.max(max, nums.get(row).get(col+1));
            }


        }
        return new int[]{start, end};

    }
}

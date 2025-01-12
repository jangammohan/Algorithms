package com.example.september.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeetingRooms2_253 {

    public static void main(String[] args) {
        MeetingRooms2_253 meet = new MeetingRooms2_253();
        System.out.println(meet.leetSolution(new int[][]{{9,10}, {4,9},{4,17}}));
    }

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0) {
            return 0;
        }



        int res =1;
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]) );
        map.put(1, intervals[0][1]);
        for(int i =1; i< intervals.length; i++) {
            boolean existingRoom = false;

            for(Integer val : map.keySet()) {
                if( map.get(val) <= intervals[i][0]) {
                    map.put(val, intervals[i][1]);
                    existingRoom = true;
                    break;
                }
            }

            if(!existingRoom) {
                res++;
                map.put(res, intervals[i][1]);
            }
        }
        return res;
    }

    //Leet solution others


    public int leetSolution(int[][] intervals) {

        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];

       // Arrays.sort(intervals, (int1, int2)-> Integer.compare(int1[0], int2[0]));
        for(int i =0 ; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res =0; int endInd =0;
        for(int i =0 ; i< start.length; i++) {
            if (start[i] < end[endInd]) {
                res++;
            } else{
                endInd++;
            }
            }

        return res;
    }

}

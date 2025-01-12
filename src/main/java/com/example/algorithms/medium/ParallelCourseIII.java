package com.example.algorithms.medium;

import java.util.*;

public class ParallelCourseIII {

    List<Integer> pre = new ArrayList();
    List<Integer> courseList = new ArrayList();
    public static void main(String args[]) {
        int[][] relations =  {{1,5}, {2,5}, {3,5}, {3,4},{4,5}}; // {{1,2}, {2,3}, {3,1}}; // {{1,3}, {2,3}};
        int[] time = {1,2,3,4,5};
       System.out.println( minimumSemesters(5, relations, time) );
    }

    public static  int minimumSemesters(int n, int[][] relations, int[] time) {

        Map<Integer, List<Integer>> coursesRel = new HashMap<>();
        //Map<Integer, Integer> preCount = new HashMap<>();
        int[] preReq = new int[n+1];



       // int i =0;
        for(int[] a : relations) {
            coursesRel.computeIfAbsent(a[0], key -> new ArrayList<>()).add(a[1]) ;
            ++preReq[a[1]];
        }
     Queue<Integer> preQueue = new LinkedList<>();

        for(int j=1 ;j< preReq.length; j++) {
            if(preReq[j] ==0 ){
                preQueue.offer(j);
            }
        }

        int competedCourse = 0;
        int result =0;
        while (preQueue.size() > 0) {

            competedCourse+=preQueue.size();
           // result++;

            for(int k= preQueue.size(); k > 0; k--) {

                int temp =  preQueue.poll();
                    result = Math.max(time[temp-1],result);

                for (int a : coursesRel.getOrDefault(temp, new ArrayList<>())) {
                    preReq[a]-= 1;
                    if(preReq[a] == 0) {
                        preQueue.offer(a);
                        result+=time[a-1];
                    }
                }
            }

        }

        return competedCourse == (n) ? result : -1;
    }


}

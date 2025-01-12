package com.example.algorithms.medium;

import java.util.*;

public class ParallelCourseII {

    List<Integer> pre = new ArrayList();
    List<Integer> courseList = new ArrayList();
    public static void main(String args[]) {
        int[][] relations = {{12,8},{2,4},{3,7},{6,8},{11,8},{9,4},{9,7},{12,4},{11,4},{6,4},{1,4},{10,7},{10,4},{1,7},{1,8},{2,7},{8,4},{10,8},{12,7},{5,4},{3,4},{11,7},{7,4},{13,4},{9,8},{13,8}}; // {{2,1}, {3,1}, {1,4}}; // {{1,2}, {2,3}, {3,1}}; // {{1,3}, {2,3}};
       System.out.println( minimumSemesters(13, relations, 9) );
    }

    public static  int minimumSemesters(int n, int[][] relations, int maxCourses) {

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
            int maxCourse = (preQueue.size()> maxCourses) ? maxCourses: preQueue.size();
            competedCourse+=maxCourse;
            result++;

            for(int k= maxCourse; k > 0; k--) {

                int temp =  preQueue.poll();


                for (int a : coursesRel.getOrDefault(temp, new ArrayList<>())) {
                    preReq[a]-= 1;
                    if(preReq[a] == 0)
                        preQueue.offer(a);
                }
            }

        }

        return competedCourse == (n) ? result : -1;
    }


}

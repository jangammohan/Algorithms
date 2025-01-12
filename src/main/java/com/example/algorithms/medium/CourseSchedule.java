package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
// DFS Reference
public class CourseSchedule {

    public static void main(String args[]) {
        int numCourses = 2;
        int[][] prerequisites =   {{1,0}, {2,0}, {3,1}, {3,2}};//{{1,0}}; //



        findOrder(numCourses,prerequisites);

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //ArrayList<Integer> arrayList = new ArrayList<>();

        int[] results = new int[numCourses];
        if(prerequisites.length == 0 && numCourses ==1)
            return new int[0];

        if(prerequisites.length == 0 && numCourses ==2) {
            results[0] = 1;
            results[1] = 0;
            return results;
        }

        if(prerequisites.length == 1) {
            results[0] = prerequisites[0][1];
            results[1] = prerequisites[0][0];
            return results;
        }

//        if(prerequisites.length == 1) {
//            results = prerequisites[0][1]);
//            arrayList.add(prerequisites[1][0]);
//
//            return arrayList.stream().mapToInt(i->i).toArray();
//
//        }


        boolean visited[] = new boolean[prerequisites.length];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<prerequisites.length; i++) {
            if(visited[0] == false) {
                findCoursePath(i, prerequisites, stack, visited );
            }
        }

        int i=0;
        while(!stack.empty()) {
            System.out.print(stack.peek()+"\t");
            results[i++] = stack.pop();
        }

        return  results;
    }

    public static void findCoursePath(int index, int[][] preReq, Stack stack, boolean[] visited) {

        visited[index] = true;
        int temp[] = preReq[index];

        for(int val : temp) {

            if(!visited[val]) {
                findCoursePath(val, preReq, stack, visited);
            }
        }

        stack.push(index);

    }
}

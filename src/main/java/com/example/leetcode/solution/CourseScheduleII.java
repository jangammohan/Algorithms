package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleII {

        public static void main(String args[]) {
            CourseScheduleII course = new CourseScheduleII();
            int[][] prerequisites = {{1,0}}; //{{1,0},{2,0},{3,1},{3,2}};
            int[] results = course.findOrder(2, prerequisites);

            for(int a : results) {
                System.out.print(a);
            }
        }

    private ArrayList[] graph;
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        graph = new ArrayList[numCourses];

        // states: 0 = unknown, 1 = visiting, 2 = visited
        int[] visit = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList < Integer > ();
        }
        for (int[] p: prerequisites) {
            graph[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfsCyclic(i, visit, queue)) return new int[0];
        }

        int i = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            result[i++] = queue.poll();
        }
        return result;
    }
    private boolean dfsCyclic(int cur, int[] v, Queue<Integer> queue) {
        if (v[cur] == 1) return true;
        if (v[cur] == 2) return false;
        v[cur] = 1;
        for (int i = 0; i < graph[cur].size(); i++) {
            if (dfsCyclic((int) graph[cur].get(i), v, queue)) return true;
        }
        v[cur] = 2;
        queue.offer(cur);
        return false;
    }

}

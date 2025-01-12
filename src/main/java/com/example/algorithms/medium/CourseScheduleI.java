package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {

    public static void main(String args[]) {

        int[][] preq = {{1,0},{2,0},{3,1},{3,2}};//{ {0,1}};
        CourseScheduleI courseScheduleI = new CourseScheduleI();
        boolean result = courseScheduleI.canFinish(4, preq);
        System.out.println(result);
    }

    ArrayList[] listArray;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        listArray = new ArrayList[numCourses];

        for(int i=0; i<numCourses;i++) {
            listArray[i] = new ArrayList<Integer>();
        }

        for(int k=0; k<prerequisites.length;k++) {
            listArray[prerequisites[k][0]].add(prerequisites[k][1]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[numCourses];

        for(int j=0; j<numCourses; j++) {
            if(dfsCyclic(queue, visited, j)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfsCyclic(Queue queue, boolean[] visited, int index) {
        if(visited[index]) {
            return true;
        }

        visited[index] = true;
        List list = listArray[index];

        for(int i=0; i< list.size(); i++) {
            if(dfsCyclic(queue, visited, (int)list.get(i))) {
                return true;
            }

        }

        visited[index] = false;

        return false;
    }
}

package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Building {
    int x;
    int y;

    Building(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ShortestDistanceBuilding {



    int grid[][] = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};// {{1,1}};//{{1}};//{{1,0}}; //{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    int nums[][] = new int[grid.length][grid[0].length];
    int reached[][] = new int[grid.length][grid[0].length];
    int[][] dirs ={{1,0}, {-1,0}, {0,1}, {0, -1}};
    Queue<int[]> queue =  new LinkedList<>();
    int countBuilding = 0;
    public static void main(String args[]) {

        ShortestDistanceBuilding sdb = new ShortestDistanceBuilding();




        System.out.println("result ->" + sdb.findBuildingCoordinates(sdb.grid));

    }

   public  int findBuildingCoordinates(int[][] grid) {


        if(grid == null || grid.length == 1 && grid[0].length == 1) {
            return -1;
        }

       int nums[][] = new int[grid.length][grid[0].length];
       int reached[][] = new int[grid.length][grid[0].length];

        for(int i =0 ; i < grid.length;i++) {
            for(int j =0; j<grid[i].length; j++ ) {
                if(grid[i][j] == 1) {

                    findshortestTravel(grid,i,j, nums, reached );
                    countBuilding++;
                }
            }
        }

       int res = Integer.MAX_VALUE;
       for(int i =0; i< grid.length; i++) {
           for(int j=0; j< grid[i].length; j++) {
               if(grid[i][j] == 0 && reached[i][j] == countBuilding) {
                   res = Math.min(res, nums[i][j]);
               }

           }
       }
       return res != Integer.MAX_VALUE ? res : -1;
    }

     void findshortestTravel(int grid[][], int x, int y,  int nums[][],   int reached[][]) {

            boolean visited[][] = new boolean[grid.length][grid[x].length];
            queue.add(new int[]{x,y});
            int layer =1;
            while(!queue.isEmpty()) {
                int size = queue.size();

               for(int k=0; k<size; k++ ) {
                   int temp[] = queue.poll();

                   visited[temp[0]][temp[1]] = true;

                   for (int[] dir : dirs) {

                       int xval = temp[0] + dir[0];
                       int yval = temp[1] + dir[1];

                       if (xval < 0 || xval > grid.length - 1 || yval < 0 || yval > grid[x].length - 1
                               || visited[xval][yval] || grid[xval][yval] != 0) {
                           continue;
                       }
                       queue.add(new int[]{xval, yval});
                       nums[xval][yval] += layer;
                       reached[xval][yval]++;
                       visited[xval][yval] = true;
                   }
               }

                layer++;

                }



            }



}

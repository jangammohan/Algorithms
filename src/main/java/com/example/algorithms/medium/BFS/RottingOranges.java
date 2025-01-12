package com.example.algorithms.medium.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int grid[][] = {{2,1,1}, {1,1,0}, {0,1,1}};
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {


        Queue<int[]> rottenQueue = new ArrayDeque<>();
        int result = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1},{0,1}};
        int countFresh =0;
        for(int i=0;i< grid.length;i++) {
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 2) {
                    rottenQueue.add(new int[]{i,j});
                }
                if(grid[i][j] !=0){
                    countFresh++;
                }

            }

        }
        int count =0;
        while(!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            count+= size;
            while(size > 0) {
                int temp[] = rottenQueue.poll();


                for (int indexArr[] : dirs) {
                    int row = temp[0] + indexArr[0];
                    int col = temp[1] + indexArr[1];
                    if ( row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||  grid[row][col] == 0 ||  grid[row][col] == 2) {
                        continue;
                    }
                        rottenQueue.add(new int[]{row, col});
                        grid[row][col] = 2;

                }
                size--;
            }
            if(!rottenQueue.isEmpty()) {
                result++;
            }

        }



        return countFresh == count ? result : -1;
    }
}

package com.example.november;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class MinimumObstacle_2290 {
    int dirs[][] = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void main(String[] args) {
        MinimumObstacle_2290 obstacle = new MinimumObstacle_2290();
        System.out.println(obstacle.minimumObstaclesLeet(new int[][]{{0,1,1},{1,1,0},{1,1,0}}));
    }
    public int minimumObstacles(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        int res =0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        grid[0][0] = -1;
        while(!queue.isEmpty()) {
            Queue<int[]> q2 = new ArrayDeque<>();
           // int size = queue.size();

            while( !queue.isEmpty()) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];
                if(x == row-1 && y == col-1){
                    return res;
                }

                for(int[] dir: dirs) {
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if( nx>=0 && nx < row && ny>=0 && ny<col && grid[nx][ny] != -1) {
                        if(grid[nx][ny] == 0) {
                            queue.add(new int[]{nx,ny});
                        }else {
                            q2.add(new int[]{nx, ny});
                        }
                        grid[nx][ny] = -1;
                    }
                }

            }
            queue= q2;
            //i=0;
            res++;
        }
        return -1;
    }


    //Leet Solution using dp

    public int minimumObstaclesLeet(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        int res[][] =new int[row][col];
        for(int[] r : res){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,0});
        res[0][0] = 0;
        while(!queue.isEmpty()) {

                int[] temp = queue.poll();
                int obstacles = temp[0];

                for(int[] dir: dirs) {
                    int nx = temp[1]+dir[0];
                    int ny = temp[2]+dir[1];
                    if( nx>=0 && nx < row && ny>=0 && ny<col && res[nx][ny] == Integer.MAX_VALUE) {
                        if(grid[nx][ny] == 1) {
                            res[nx][ny] = obstacles+1;
                            queue.addLast(new int[]{obstacles+1,nx, ny});

                        }else {
                            res[nx][ny] = obstacles;
                            queue.addFirst(new int[]{obstacles,nx, ny});
                        }

                    }
                }

        }
        return res[row-1][col-1];
    }

}

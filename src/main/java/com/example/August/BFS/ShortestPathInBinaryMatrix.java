package com.example.August.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    int dirs[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1},};

    int grid[][] = {{0,0,0}, {1,1,0}, {1,1,0}};
    public static void main(String[] args) {
        ShortestPathInBinaryMatrix s = new ShortestPathInBinaryMatrix();
        System.out.println(s.shortestPathBinaryMatrix(s.grid));
    }

    public  int shortestPathBinaryMatrix(int[][] grid) {

        int length = 1;
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {
            int size = queue.size();


            for(int i =0 ; i<size; i++) {
                int[] current = queue.poll();
                grid[current[0]][current[1]] = 1;
                for (int[] dir : dirs) {

                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];

                    if (row >= 0 && row < grid.length && col>=0 && col < grid.length  && grid[row][col] == 0) {
                        queue.add(new int[]{row, col});

                        if(row == grid.length-1 && col == grid[0].length-1)
                            return length+1;
                    }

                }
            }
            length++;

        }


        return 0;
    }
}

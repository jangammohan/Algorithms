package com.example.september.array;

import java.util.ArrayDeque;
import java.util.Queue;

public class IslandPerimeter_463 {

    public static void main(String[] args) {
        IslandPerimeter_463 island = new IslandPerimeter_463();
        int[][] grid = {{1,1}, {1,1}};
        System.out.println(island.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {

        int result =0;

        for(int i =0; i<grid.length; i++) {
            for(int j =0; j< grid[i].length; j++) {
                if(grid[i][j] == 1){
                    return bfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int bfs(int[][] grid, int row, int col  ) {

        int dirs[][] = {{1,0},{-1,0}, {0,1}, {0,-1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {row, col});
        boolean visited[][] = new boolean[grid.length][ grid[0].length];
        visited[row][col] = true;
        int result =0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size >0) {
                int[] curr = queue.poll();

                int count = 4;
                for(int[] dir : dirs) {

                    int x = curr[0]+dir[0];
                    int y = curr[1]+dir[1];

                    if(x <0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y] == 0 ) {
                        continue;
                    }

                    if(grid[x][y] == 1 && visited[x][y]) {
                        count--;
                    } else {
                        visited[x][y] = true;
                        queue.add(new int[]{x,y});
                        count--;
                    }
                }
                size--;
                result+= count;

            }

        }

        return result;

    }

}

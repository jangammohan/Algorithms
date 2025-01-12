package com.example.August.BFS;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIsland_694 {



   static int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
   static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        int grid[][] = { {1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(numDistinctIslands(grid));
    }
    public static int numDistinctIslands(int[][] grid) {

        int ret =0;
        for(int i=0; i< grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid,sb, 0,0);
                    set.add(sb.toString());
                    ret++;
                }
            }
        }


        return set.size();
    }

    public static void  dfs( int start, int end, int[][] grid, StringBuilder sb, int xpos, int ypos) {

        if(start < 0 || start >= grid.length || end < 0 || end >= grid[0].length || grid[start][end] == 0 ) {
            return ;
        }

        sb.append(xpos+""+ypos);
        grid[start][end] = 0;

        for(int[] dir : dirs) {
            dfs(start+dir[0], end+dir[1], grid, sb, xpos+dir[0], ypos+dir[1]);
        }
    }

}


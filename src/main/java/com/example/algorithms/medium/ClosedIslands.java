package com.example.algorithms.medium;

public class ClosedIslands {

    static int[][] dir = {{0,-1}, {0,1},{-1,0}, {1,0}};

    public static void main(String args[]) {
        int[][] grid =  {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};//{{0,0,1,0,0}, {0,1,0,1,0}, {0,1,1,1,0}};
        int result = 0;
        for(int i=1; i< grid.length-1 ;i++) {
            for(int j=1; j< grid[i].length-1;j++) {
                if(grid[i][j] == 0) {
                   if(findClosedIsland(grid, i,j))
                       result++;

                }
            }
        }

        System.out.print(result);
    }

    public static boolean findClosedIsland(int[][] grid, int x, int y) {

        if(x<0 || x>grid.length || y<0 || y<grid.length) {
            return false;
        }

        if(grid[x][y] == 1)
            return true;

        grid[x][y] = 1;

        boolean res = true;

        for(int[] a : dir)
        {
            res = res & findClosedIsland(grid,x+a[0],y+a[1]);
        }
        return  res;
    }

}

package com.example.August.BFS;

public class NumberOfDaysToDisconnectIsland_1568 {

    public static void main(String[] args) {
        NumberOfDaysToDisconnectIsland_1568 num = new NumberOfDaysToDisconnectIsland_1568();

        int[][] grid = {{1,1}};
        System.out.println(num.minDays(grid));
    }

    public  int minDays(int[][] grid) {

        int res = countIsland(grid);
        if(res!=1 ){
            return 0;
        }

        for(int i =0; i<grid.length;i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(countIsland(grid)!= 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    public int countIsland(int[][] grid) {

        int numberIslands =0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i =0 ; i< grid.length;i++) {
            for (int j=0;j< grid[i].length; j++) {
                if(grid[i][j] == 1 && !visit[i][j]) {
                    numberIslands++;
                    dfs(i, j, grid, visit);
                }
            }
        }

        return numberIslands;
    }

    public void dfs(int row, int col, int[][] grid, boolean[][] visit ) {

        visit[row][col] = true;

        int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};

        for(int[] dir : dirs) {
            int x = row+dir[0];
            int y = col+dir[1];

            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && !visit[x][y] && grid[x][y] ==1) {
                dfs(x,y, grid, visit);
            }
        }

    }

}

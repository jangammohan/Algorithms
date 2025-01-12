package com.example.August.BFS;

public class RegionCutBySlash {
    public static void main(String[] args) {

    }

    public int regionsBySlashes(String[] grid) {
       int row = grid.length *3;
       int col = grid[0].length() * 3;

       int scaledArr[][] = new int[row][col];

        for(int i=0; i<grid.length;i++){
            for(int j =0 ; j< grid[i].length(); j++) {
                 if(grid[i].charAt(j) == '/') {
                     scaledArr[i*3][j*3+2] = 1;
                     scaledArr[i*3+1][j*3+1] = 1;
                     scaledArr[i*3+2][j*3] = 1;

                 }
                if(grid[i].charAt(j) == '\\') {
                    scaledArr[i*3][j*3] = 1;
                    scaledArr[i*3+1][j*3+1] = 1;
                    scaledArr[i*3+2][j*3+2] = 1;

                }
            }


        }

        boolean vist[][]  = new boolean[row][col];
        int result = 0;
        for(int i = 0; i< scaledArr.length; i++) {
            for(int j=0; j< scaledArr[i].length; j++) {
                if(scaledArr[i][j] == 0 && !vist[i][j] ) {
                    dfs(i, j, vist, scaledArr);
                    result+=  1;
                }
            }
        }
        return result;
    }

    private int dfs(int row, int col, boolean visit[][], int[][] scal) {

        if(row <0 || row >= scal.length || col < 0 || col >= scal[0].length || scal[row][col] != 0
                || visit[row][col] ) {

            return 0;
        }

        visit[row][col] = true;

        return 1+ dfs(row+1,col, visit, scal)
                + dfs(row-1,col, visit, scal)
                + dfs(row,col-1, visit, scal)
                + dfs(row,col+1, visit, scal);
    }
}

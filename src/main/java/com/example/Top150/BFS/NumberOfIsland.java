package com.example.Top150.BFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.print(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int mat[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        int result = 0;
        for(int i=0;i< grid.length;i++){
            for(int j =0; j< grid[0].length;j++ ) {
                if(grid[i][j] == '1') {
                   result+= DFS(i, j, grid, mat);
                }
            }

        }
    return result;
    }


    public static int DFSRefactor(int i, int j, char[][] grid, int[][] mat ) {

        if ( i<0 || j<0 || i>= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] ='0';
            for (int k = 0; k < mat.length; k++) {
                DFSRefactor(i+mat[k][0], j+mat[k][1], grid, mat);
            }


        return 1;
    }

    public static int DFS(int i, int j, char[][] grid, int[][] mat ) {
        Queue<int[]> one = new ArrayDeque();
        one.add(new int[]{i,j});
        while(!one.isEmpty()) {
                int temp[] = one.poll();
                grid[temp[0]][temp[1]] = '0';
            for (int k = 0; k < mat.length; k++) {
                int row = temp[0]+mat[k][0];
                int col = temp[1]+mat[k][1];
                if ( row<0 || col<0 || row == grid.length || col == grid[0].length ) {
                    continue;
                }
                    if( grid[row][col] == '0' ) {

                        break;
                    }else {
                    one.offer(new int[]{row,col});
                    }
                }


            }


        return 1;
    }

}

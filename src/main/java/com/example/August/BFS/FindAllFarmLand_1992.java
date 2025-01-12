package com.example.August.BFS;

import java.util.ArrayList;
import java.util.List;

public class FindAllFarmLand_1992 {

    int[][] dirs = {{0,-1}, {0,1}, {1,0}, {-1,0}};

    public static void main(String[] args) {
        FindAllFarmLand_1992 farm = new FindAllFarmLand_1992();

        int[][] land = {{1,1,1,1,1,1,1,1,1,1,1,1}};
        int[][] res = farm.findFarmland(land);
        System.out.println(res);
    }

    public int[][] findFarmland(int[][] land) {

        boolean[][] visited = new boolean[land.length][land[0].length];
        List<int[]> ls = new ArrayList<>();

        for(int i=0; i< land.length; i++) {
            for(int j =0 ; j< land[i].length; j++){
                if(land[i][j] == 1 && !visited[i][j]) {
                    int[] curr = new int[]{i,j,i,j};
                    dfs(land, i , j, visited, curr );
                    ls.add(curr);
                }
            }
        }
        return ls.toArray(new int[ls.size()][]);
    }

    private void dfs(int[][] land, int row, int col, boolean[][] visit, int[] curr) {

        if(row<0 || row>=land.length || col < 0 || col >= land[row].length || land[row][col] == 0 || visit[row][col] ) {
            return ;
        }

        visit[row][col] = true;
        curr[2] = Math.max(row, curr[2]);
        curr[3] = Math.max(col, curr[3]);
        for(int[] dir : dirs) {
            dfs(land, row+dir[0], col+dir[1], visit, curr);
        }

    }
}

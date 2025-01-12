package com.example.september.array;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Maze_490 {

    public static void main(String[] args) {
        Maze_490 maze = new Maze_490();

        int[][] maz = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        boolean visited[][] = new boolean[maz.length][maz[0].length];
        System.out.println(maze.dfs(maz, new int[]{0,4}, new int[]{3,2}, visited ));
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {

       int row = start[0];
       int col = start[1];

       if (visited[row][col]) {
           return false;
       }

       if(row == destination[0] && col == destination[1]){
           return true;
       }

       visited[row][col] = true;

       int dirs[][] = new int[][]{{1,0},{-1,0}, {0,1}, {0,-1}};

       for(int[] dir : dirs) {
           int x = row + dir[0];
           int y = col + dir[1];

           while(isValid(x, y, maze)) {
               x = x+dir[0];
               y = y+dir[1];
           }

           if(dfs(maze, new int[]{x,y}, destination, visited )) {
               return true;
           }
       }

        return false;

    }

    private boolean isValid(int row, int coll, int[][] grid) {
        return (row>= 0 && row < grid.length && coll >=0 && coll < grid[0].length && grid[row][coll] != 1  );
    }

}

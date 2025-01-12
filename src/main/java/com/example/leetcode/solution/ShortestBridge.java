package com.example.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // DFS to label the first island
        boolean[][] visited = new boolean[rows][cols];
        boolean foundFirstIsland = false;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows && !foundFirstIsland; i++) {
            for (int j = 0; j < cols && !foundFirstIsland; j++) {
                if (grid[i][j] == 1) {
                    dfsLabelIsland(grid, visited, queue, i, j);
                    foundFirstIsland = true;
                }
            }
        }

        // BFS to find the shortest bridge
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int shortestPath = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                        if (grid[newX][newY] == 1) {
                            return shortestPath; // Found the shortest bridge
                        }
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            shortestPath++;
        }

        return -1; // No bridge found
    }

    private void dfsLabelIsland(int[][] grid, boolean[][] visited, Queue<int[]> queue, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] || grid[x][y] == 0) {
            return;
        }

        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        dfsLabelIsland(grid, visited, queue, x - 1, y);
        dfsLabelIsland(grid, visited, queue, x + 1, y);
        dfsLabelIsland(grid, visited, queue, x, y - 1);
        dfsLabelIsland(grid, visited, queue, x, y + 1);
    }

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(shortestBridge.shortestBridge(grid)); // Output: 2
    }
}

package com.example.amazon.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MineSweeper {

    public static void main(String[] args) {
        MineSweeper sweeper = new MineSweeper();
        char[][] board= {{'E','E','E','E','E'}, {'E','E','M','E','E'}, {'E','E','E','E','E'}, {'E','E','E','E','E'} };
        int[] clicks = {3,0};
        char[][] result = sweeper.updateBoard(board, clicks);
        System.out.println(Arrays.deepToString(result));
    }

    public char[][] updateBoard(char[][] board, int[] click) {

        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            boolean visited[][] = new boolean[board.length][board[0].length];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(click);

            int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}, {1,1},{-1,-1},{-1,1},{1,-1}};

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                visited[cur[0]][cur[1]] = true;

                for(int[] temp: dir) {
                    int row = temp[0]+cur[0];
                    int col = temp[1]+cur[1];

                    if(  row >=0 && row < board.length && col>=0 && col< board[0].length && !visited[row][col] ) {
                        if(board[cur[0]][cur[1]] == 'E' && board[row][col] == 'M') {
                            board[cur[0]][cur[1]] = '1';
                        }
                        else if(board[row][col] == 'B' || board[row][col] == 'M') {
                            continue;
                        } else {
                            queue.add(new int[]{row,col});
                        }
                    }
                }

                if(board[cur[0]][cur[1]] == 'E') {
                    board[cur[0]][cur[1]] = 'B';
                }

            }
        }

        return board;
    }
}

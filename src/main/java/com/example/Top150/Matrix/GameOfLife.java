package com.example.Top150.Matrix;

import java.util.Arrays;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1}, {0,0,0}};

        int dirs[][] = {{0,-1},{0,1},{-1,0},{1,0},{-1,1}, {-1,-1}, {1,1},{1,-1}};

        int DEADTOALIVE = 2;
        int ALIVETODEAD = 3;

        for(int i=0;i< board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                int live =0;

                for(int[] dir: dirs) {
                    int row = i+dir[0];
                    int col = j+dir[1];
                    if(row >= 0 && row<board.length && col>=0 && col<board[i].length) {
                        if(board[row][col] == 1 || board[row][col] == ALIVETODEAD){
                           live++;
                        }
                    }
                }
                if(board[i][j] == 1 && live < 2 && live !=3  ) {
                    board[i][j] = ALIVETODEAD;
                } else {
                    if(board[i][j] == 0 && live == 3 ){
                        board[i][j] = DEADTOALIVE;
                    }
                }


            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == DEADTOALIVE) {
                    board[r][c] = 1;
                }
                else if (board[r][c] == ALIVETODEAD) {
                    board[r][c] = 0;
                }
            }
        }

        Arrays.stream(board).forEach(a-> {
            Arrays.stream(a).forEach(System.out::print);
            System.out.println("");
        });

    }
}

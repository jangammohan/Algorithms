package com.example.Top150.Matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {
    public static void main(String[] args) {

    }

    boolean isValidSudoku(char[][] board) {

        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();

        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                if(board[i][j] != '.') {

                    if(rowSet.contains(board[i][j]))
                        return false;
                    rowSet.add(board[i][j]);

                }

                if(board[j][i] != '.' ) {

                    if(colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);

                }

            }
            rowSet.clear();
            colSet.clear();
        }

        rowSet.clear();

        for(int i=0; i<board.length;i+=3){
            for(int j=0; j<board[0].length; j+=3) {

                for(int k =i ; k<i+3;k++) {
                    for(int l=j; l<j+3; l++){
                        if(board[i][j] != '.' ){

                            if(rowSet.contains(board[i][j])) {
                                return false;
                            }
                            rowSet.add(board[k][l]);
                        }
                    }
                }
                rowSet.clear();
            }
        }

        return true;
    }
}

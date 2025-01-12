package com.example.Top150.Matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();


        for(int i=0; i< matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0 ){
                    rows.add(j);
                    cols.add(i);
                }
            }
        }

        for(int row : rows) {
            for(int i=0;i<matrix.length;i++){
                matrix[i][row] =0;
            }
        }

        for(int col : cols) {
            for(int i=0;i<matrix[0].length;i++){
                matrix[col][i] =0;
            }
        }

        Arrays.stream(matrix).forEach( a -> {
            Arrays.stream(a).forEach(System.out::print);
            System.out.println("");
        });
    }
}

package com.example.Top150.Matrix;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int begin = 0;
        int end = matrix.length-1;

        for(int i =0; i<matrix[0].length;i++) {
            int temp = matrix[begin][i];
            matrix[begin][i] = matrix[end][i];
            matrix[end][i] = temp;
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j= i+1; j<matrix[i].length;j++){

                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp;

            }
        }
        Arrays.stream(matrix).forEach( a -> {
            Arrays.stream(a).forEach(System.out::print);
            System.out.println(" ");
        });
    }
}

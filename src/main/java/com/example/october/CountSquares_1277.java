package com.example.october;

public class CountSquares_1277 {

    public static void main(String[] args) {
        CountSquares_1277 count = new CountSquares_1277();
        int matrix[][] = new int[][]{{1,0,1},{1,1,0},{1,1,0}};
        System.out.println(count.countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {
        int result =0;

        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row+1][col+1];

        for(int i =1; i<=row; i++ ) {
            for(int j =1; j<=col; j++){

                if( matrix[i-1][j-1] == 1) {

//                    dp[i][j] = matrix[i][j];
//
//                    int left = ( i >= 0 && j-1 >= 0 ) ? dp[i][j-1] : 0;
//                    int top = (i-1>=0 && j>=0) ? dp[i-1][j] : 0;
//                    int topLeft = (i-1 >=0 && j-1 >=0) ? dp[i-1][j-1]:0;
//                    int temp = Math.min(left, Math.min(top, topLeft));
//                   dp[i][j]+= temp;
//                   result+= dp[i][j];

                    dp[i][j] = 1+ Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]));
                    result+= dp[i][j];
                }


            }
        }


        return result ;
    }
}

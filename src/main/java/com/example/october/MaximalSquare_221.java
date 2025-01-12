package com.example.october;

import java.util.HashMap;
import java.util.Map;

public class MaximalSquare_221 {

    public static void main(String[] args) {
        MaximalSquare_221 square = new MaximalSquare_221();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(square.maximalSquareUsingDFS(matrix));
    }
// Using DP
    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];

        int result =0;

        for(int i =0 ; i< row; i++) {
            for(int j =0 ; j< col; j++) {
                if(matrix[i][j] == '1') {
                    int top = (i-1 >=0 && i-1 < row) ? dp[i-1][j] : 0;
                    int left = (j-1 >= 0 && j-1<col) ? dp[i][j-1] :0;
                    int topLeft = (i-1 >= 0 && i-1<row && j-1>=0 && j-1<col) ? dp[i-1][j-1] : 0;
                    dp[i][j] = Math.min(top, Math.min(left, topLeft)) +1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }

        //Using DFS
    public int maximalSquareUsingDFS(char[][] matrix) {
       int result =0 ;
       Map<String, Integer> memo = new HashMap<>();
       //boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length;i++) {
            for(int j=0; j< matrix[0].length;j++) {
                String key = i+""+j;
                if(matrix[i][j] == '1' && memo.get(key) == null) {
                    result = Math.max(result, dfs(matrix, i,j, memo));
                }
            }
        }
        return result * result;
    }

    public int dfs(char[][] matrix, int row, int col, Map<String, Integer> memo) {
        if(row < 0 || row >= matrix.length || col < 0 || col>=matrix[row].length || matrix[row][col] == '0' ){
            return 0;
        }
        String key = row+","+col;
        if(memo.get(key) != null) {
            return memo.get(key);
        }
        int top =  dfs(matrix,row-1,col, memo) ;
        int left = dfs(matrix, row, col-1, memo) ;
        int topLeft = dfs(matrix, row-1, col-1, memo) ;

        int temp = Math.min(top, Math.min(left, topLeft));

        return temp+1;
    }
}

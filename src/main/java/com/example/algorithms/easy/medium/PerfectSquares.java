package com.example.algorithms.easy.medium;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        int n = 13;
       int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1 ; i<= n; i++) {
            for(int j = 1; j*j <= i ; j++) {
                int temp = dp[i-j*j]+1;
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.print(dp[n]);


    }
}

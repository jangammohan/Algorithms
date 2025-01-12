package com.example.amazon.medium;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {186,419,83,408};
        int amount = 6249;



        System.out.print(coins(coins, amount));
    }

    public static int coins(int[] coins, int amount) {


     int dp[] = new int[amount+1];
     dp[0] = 0;

     for(int i =1; i<= amount; i++) {
         if(i == amount) {
             System.out.print(i);
         }
            dp[i] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i-coin < 0)
                    break;
                if(dp[i-coin] != Integer.MAX_VALUE ) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);

                }
            }

     }

      return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount] ;
    }

    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int result =0;
        for(int i=coins.length-1; i>=0; i--) {

            if(amount >= coins[i] ) {
                int cur= amount/coins[i];
                amount -= coins[i] * cur ;
                result=  result+cur;

            }
            if(amount == 0) {
                break;
            }

        }

        return (amount ==0 ) ? result : -1;

    }
}

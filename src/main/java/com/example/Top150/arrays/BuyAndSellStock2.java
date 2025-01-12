package com.example.Top150.arrays;

public class BuyAndSellStock2 {

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};

        int min = prices[0];
        int prof =0;

        for(int i =1; i< prices.length; i++) {
            min = Math.min(min, prices[i]);

            if(prices[i]-min > 0) {
                prof+= prices[i]-min;
                min = prices[i];
            }
        }
        System.out.print(prof);
    }
}

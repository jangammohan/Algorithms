package com.example.algorithms.easy.medium;

import java.util.Arrays;

public class GasStation {
    public static void main(String[] args) {
        int gas[] = {5,8,2,8};
        int cost[] = {6,5,6,6};
        final int totalGas = Arrays.stream(gas).sum();
       final int totalCost = Arrays.stream(cost).sum();

//        for(int i =0 ; i<gas.length; i++) {
//            totalCost+= cost[i];
//            totalGas+= gas[i];
//        }

        if(totalCost > totalGas) {
            System.out.println(-1);
            return;
        }

        int start =0; int remainGas =0;

        for(int i =0 ; i < gas.length;i++) {
            remainGas = remainGas + (gas[i] -cost[i]);
            if(remainGas < 0) {
                start=i+1;
                remainGas=0;
            }
        }

        System.out.println(start);
    }
}

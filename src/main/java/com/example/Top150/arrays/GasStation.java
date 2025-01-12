package com.example.Top150.arrays;

public class GasStation {

    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        int i =0;
        for(;i<gas.length;i++) {

            if(gas[i] > cost[i]){
                int res = find(i, gas, cost);


                if(res >= 0) {
                    break ;
                }
            }
        }

        System.out.print(i);
    }

    public static int find(int index, int[] gas, int[] cost) {

        int remainGas = 0;
        for(int i =0; i<gas.length; i++) {
            remainGas+= gas[index]-cost[index];

            if(remainGas <0){
                return -1;
            }
            index++;
            if(index > gas.length-1){
                index =0;
            }


        }
        return index;
    }

    ///leetcode logic

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas =0; int totalCost = 0;

        for(int i =0 ; i<gas.length; i++) {
            totalCost+= cost[i];
            totalGas+= gas[i];
        }

        if(totalCost > totalGas) {
            System.out.println(-1);
            return -1;
        }

        int start =0; int remainGas =0;

        for(int i =0 ; i < gas.length;i++) {
            remainGas = remainGas + (gas[i] -cost[i]);
            if(remainGas < 0) {
                start=i+1;
                remainGas=0;
            }
        }

        return start;
    }
}

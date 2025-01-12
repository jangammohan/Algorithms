package com.example.algorithms.medium;

import java.util.Arrays;

public class LatestTimeToCatchBus {

    public static void main(String[] args) {
        int[] buses =  {20,30,10}; //{20,30,10};//{10,20};
        int passengers[] ={19,13,26,4,25,11,21};// {19,13,26,4,25,11,21};//{2,17,18,19};
        int capacity =2;

        System.out.println(latestTimeCatchTheBus(buses, passengers, capacity));
    }

    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

        Arrays.sort(buses);
        Arrays.sort(passengers);
        int tempCapacity = 0;
        int passengerPosition =0;
        int latestTime = 0;
        for(int i=0, j=0; i< buses.length; i++) {
            tempCapacity = 0;
            while(j< passengers.length && passengers[j] <= buses[i] && tempCapacity < capacity ) {

                    tempCapacity++;
                     ++j;

                }
                    if(tempCapacity != capacity) {
                        int res = buses[i];
                        int currentPostion = j-1;
                        while (tempCapacity > 0) {
                            if(passengers[currentPostion] == res) {
                                res--;

                            }
                            tempCapacity--;
                            currentPostion--;
                        }
                        latestTime = Math.max(latestTime,res);
                    }else {
                        int currentPostion = j-1;
                        int res =  passengers[currentPostion]-1;

                        while (tempCapacity > 0) {
                            if(passengers[currentPostion] == res) {
                                res--;

                            }
                            tempCapacity--;
                            currentPostion--;
                        }
                        latestTime = Math.max(latestTime,res);
                    }



                }



        return latestTime;
    }
}

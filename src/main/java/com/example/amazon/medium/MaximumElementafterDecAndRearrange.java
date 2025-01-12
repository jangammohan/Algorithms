package com.example.amazon.medium;

import java.util.Arrays;

public class MaximumElementafterDecAndRearrange {

    public static void main(String[] args) {
        int[] arr = {100,1,1000};
        Arrays.sort(arr);
        arr[0] =1;
        int maxSoFar = arr[0];
        for(int i =1 ; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i-1]) <= 1) {
                maxSoFar = Math.max(arr[i], arr[i-1]);
            }else {
                arr[i] = arr[i-1]+1;
                maxSoFar = arr[i];
            }

        }

        System.out.print(maxSoFar);

    }
}

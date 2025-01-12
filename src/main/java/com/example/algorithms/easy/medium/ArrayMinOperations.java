package com.example.algorithms.easy.medium;

import java.util.HashMap;
import java.util.Map;

public class ArrayMinOperations {
    public static void main(String[] args) {
        Map<Integer, Integer> intCount = new HashMap<>();
        int[] nums = {2,1,2,2,3,3};

        for(int a : nums ){
            intCount.put(a, intCount.getOrDefault(a,0)+1);


        }
        int count =0;
        for(int val : intCount.values()) {
            if(val ==1) {
                System.out.println(-1);
                break;
            }
            count += val / 3; // Count the complete sets of 3 elements
            if (val % 3 != 0) // If there are remaining elements, increment the count
                count++;

        }
        System.out.println(count);
    }
}

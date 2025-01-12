package com.example.algorithms.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToZero {

    public static void main(String[] args) {
        int nums[] = {5,6,7,8,9};
        int x=4;
        System.out.println(minOperations(nums, x));
    }

    public static int minOperations(int[] nums, int x) {
        Arrays.sort(nums);

       Set<Integer> set = new HashSet<>();

       for(int a : nums) {
           set.add(a);
       }
       int count =1;
       int target = x;
       for(int i=0; i< nums.length; i++) {
           if(set.contains(target)) {
               return count+i;
           }

           target = target -nums[i];

           if(target == 0) {
               return count+i;
           }

       }



        return -1;
    }
}

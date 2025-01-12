package com.example.algorithms.easy.medium;

import java.util.Arrays;

public class MaxFrequency {

    public static void main(String[] args) {
        int nums[] = {1,4,8,13};

        int k =5;
        Arrays.sort(nums);

       int result =1;
        int left = 0; int sum =0;
       for(int right =0; right<nums.length;right++) {
           sum+= nums[right];

           while(sum+k < (nums[right]*(right-left+1))) {
               sum-= nums[left];
               left++;
           }
           result = Math.max(result, right-left+1);
       }

       System.out.println(result);

    }
}

package com.example.algorithms.easy.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class MaximumSubArray {

    public static void main(String[] args) {

        int nums[] = {2,3,-2,4};
        MaximumSubArray sub = new MaximumSubArray();
        System.out.println(sub.maxProduct(nums));

//        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
//
//        if(nums.length ==1){
//            System.out.println(nums[0]);
//        }
//        int maxSum = nums[0];
//        int max = nums[0];
//        for(int i =1 ;i < nums.length; i++) {
//            max =  Math.max(nums[i],nums[i]+max);
//            maxSum = Math.max(maxSum, max);
//        }
//        System.out.println(maxSum);
    }

    public int maxProduct(int[] nums) {

        if(nums.length ==1){
           return nums[0];
        }

        int curMin = nums[0];
        int curMax = nums[0];
        int maxSum = nums[0];
        for(int i =1; i<nums.length;i++) {
            if(nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMin = Math.min(curMin*nums[i],  nums[i]);
            curMax = Math.max(curMax*nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);
        }

        return maxSum;
    }
}

package com.example.amazon.easy;

import java.util.Arrays;

public class MaximumproductOfThreeNumbers {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};  // {-100,-98,-1,2,3,4}

        if(nums.length == 3) {
            System.out.print(nums[0]* nums[1]* nums[2]);
        }

        Arrays.sort(nums);
        int len = nums.length;
        int max1 = nums[len-1];
        int max2 = nums[len-2];
        int max3 = nums[len-3];

        int min1 = nums[0];
        int min2 = nums[1];



        System.out.println(Math.max(max1*max2*max3, min1*min2*max1));
    }
}

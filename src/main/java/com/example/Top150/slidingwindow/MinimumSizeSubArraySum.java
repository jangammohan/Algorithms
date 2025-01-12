package com.example.Top150.slidingwindow;

import java.util.Arrays;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int nums[] = {12,28,83,4,25,26,25,2,25,25,25,12};
        int target = 213;

        System.out.print(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int n = nums.length;
        int sum =0;
        int right =0;
        int result = Integer.MAX_VALUE;
        while(left< n ) {

            while(right<n && sum<target){
                sum+=nums[right++];
            }

            if(sum >= target){
                result = Math.min(result, right-left);
            }

            sum-=nums[left];
            left++;
        }
       return (Integer.MIN_VALUE == result) ? 0: result ;
    }
}

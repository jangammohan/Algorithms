package com.example.september.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumGoodSubArraySum_3026 {

    public static void main(String[] args) {
        MaximumGoodSubArraySum_3026 max = new MaximumGoodSubArraySum_3026();
        //int nums[] = new int[]{999999980,999999981,999999982,999999983,999999984,999999985,999999986,999999987,999999988,999999989,999999990,999999991,999999992,999999993,999999994,999999995,999999996,999999997,999999998,999999999};
       int nums[] = new int[] {-1,3,2,4,5};
        System.out.println(max.maxSubArraySum(nums, 3));
    }



    public long maxSubArraySum(int[] nums, int k) {
      long prefixSum =0;
      long res = Long.MIN_VALUE;

      Map<Integer, Long> map = new HashMap<>();
        for (int i =0; i< nums.length; i++) {
            if(map.getOrDefault(nums[i], Long.MAX_VALUE) > prefixSum ) {
                map.put(nums[i], prefixSum);

            }
            prefixSum+= nums[i];

            if(map.containsKey(nums[i]+k)) {
                res = Math.max(prefixSum, prefixSum - map.get(nums[i]+k));
            }

            if(map.containsKey(nums[i]-k)) {
                res = Math.max(prefixSum, prefixSum - map.get(nums[i]-k));
            }
        }
        return res == Long.MIN_VALUE ? 0: res;
    }

    public long maximumSubarraySum(int[] nums, int k) {

        long maxSum = Integer.MIN_VALUE;

        for(int i =0 ; i< nums.length; i++) {

            for(int j =i+1; j< nums.length; j++) {
                if(Math.abs(nums[i]-nums[j]) == k) {
                    long subArrSum =0;


                    for(int start = i; start <= j; start++ ) {
                        subArrSum+= nums[start];
                    }

                    maxSum = Math.max(maxSum, subArrSum);

                }
            }

        }


        return maxSum == Integer.MIN_VALUE ? 0 : maxSum ;
    }

    public long findMaximumSubarraySum(int[] nums, int k, int start, int end) {

        if(start >= nums.length) {
            return Integer.MIN_VALUE;
        }
        long maxSum = Integer.MIN_VALUE;



        for(int i =start+1 ; i<nums.length;i++) {
            if(Math.abs(nums[start] - nums[i]) == k) {
                int tempInd = start;
                long subArraySum = 0;
                while (tempInd <= i ) {
                    subArraySum+= nums[tempInd++];
                }
               maxSum = Math.max(maxSum, subArraySum);

            }

        }


        return Math.max(maxSum, findMaximumSubarraySum(nums, k, start + 1, end));
        }

}

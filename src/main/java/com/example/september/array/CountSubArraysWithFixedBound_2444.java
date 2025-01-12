package com.example.september.array;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class CountSubArraysWithFixedBound_2444 {

    public static void main(String[] args) {
        CountSubArraysWithFixedBound_2444 count = new CountSubArraysWithFixedBound_2444();
        System.out.println(count.countSubarraysGpt(new int[]{1,1,1,1} ,1, 1));
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {

        int startSubArray =0;
        int minInd = -1;
        int maxInd = -1;
        long res =0;
        for(int i=0; i<nums.length; i++) {

            if(nums[i] < minK || nums[i] > maxK) {
               minInd = -1;
               maxInd = -1;
               startSubArray = i+1;
            }

            if(nums[i] == minK) {
                minInd = i;
            }

            if(nums[i] == maxK) {
                maxInd = i;
            }

            res+= Math.max(0L, Math.min(minInd, maxInd)-startSubArray+1);
        }

        return res;

    }


    //ChatGpt solution

    public long countSubarraysGpt(int[] nums, int minK, int maxK) {

        int left =0;
        int right = 0;
        long res =0;

        ArrayDeque<Integer> minQueue = new ArrayDeque<>();
        ArrayDeque<Integer> maxQueue = new ArrayDeque<>();

        for(; right<nums.length; right++) {

            if(nums[right] < minK || nums[right] > maxK) {
                left = right +1;

                minQueue.clear();
                maxQueue.clear();
            }



            if(nums[right] == minK) {

                minQueue.add(right);

            }

            if(nums[right] == maxK) {
                maxQueue.add(right);

            }

            if(!minQueue.isEmpty() && !maxQueue.isEmpty()) {
                res+= Math.max(0, Math.min(minQueue.peekLast(), maxQueue.peekLast()) - left + 1);
            }
        }
        return res;
    }
}

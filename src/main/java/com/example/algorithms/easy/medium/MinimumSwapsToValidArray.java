package com.example.algorithms.easy.medium;

public class MinimumSwapsToValidArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,5,3,1};

        if(nums.length == 1) {
            System.out.println(0);
        }

        int minIndex = 0;
        int maxIndex = 0;
        int count =0;
        for(int i = 1; i< nums.length;i++) {

            minIndex = (nums[minIndex] > nums[i]) ? i : minIndex;
            maxIndex = (nums[maxIndex] > nums[i]) ? maxIndex : i;

        }

       if(minIndex <= maxIndex) {
           count = minIndex + (nums.length-1- maxIndex);
       } else {
           count= minIndex + (nums.length-1 - (maxIndex +1) );
       }

        System.out.println(count);
    }
}

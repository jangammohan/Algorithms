package com.example.algorithms.easy.medium;

public class MaximumTop {
    public static void main(String[] args) {
        int[] nums = {99,95,68,24,18};
        int k =69;
        if(nums.length == 1 && k%2 ==1) {
            System.out.println(-1);
        }

        int max = 0;
        for(int i =0 ; i < Math.min(k, nums.length); i++) {
            max = Math.max(max, nums[i]);
        }

        if(k< nums.length) {
            max= Math.max(max, nums[k]);
        }

        System.out.println(max);

    }
}

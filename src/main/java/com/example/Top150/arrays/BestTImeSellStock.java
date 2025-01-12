package com.example.Top150.arrays;

public class BestTImeSellStock {

    public static void main(String[] args) {

        int nums[] = {7,1,5,3,6,4};

        int min = nums[0];
        int prof = 0;


        for(int i =1 ; i< nums.length; i++ ) {
            min = Math.min(min, nums[i]);
             prof = Math.max(prof, nums[i] - min);


        }
        System.out.print(prof);
    }
}

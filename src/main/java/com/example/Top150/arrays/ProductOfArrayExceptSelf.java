package com.example.Top150.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums= {1,2,3,4};
        int n = nums.length;
        int result[] = new int[n];

        int prod =1;
        result[0] =1;
        for(int i=0;i<n;i++) {

            if(i>0 ) {
                result[i] = prod;
            }
            prod*= nums[i];
        }
        prod = nums[n-1];
        for(int i=n-2;i>=0;i--) {

           result[i] = prod * result[i];
           prod*=nums[i];
        }

        Arrays.stream(result).forEach(System.out::println);
    }
}

package com.example.algorithms.easy;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int nums[] = {3,1,2,4};

        int i =0;

        for(int j=0; j< nums.length ; j++) {
            if(nums[j]%2 == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

        Arrays.stream(nums).forEach(a -> System.out.println(a));

    }
}

package com.example.algorithms.medium;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

//        int numbers = nums.length -1;
//        int result =0;
//
//        for(int i=1;i<=numbers;i++) {
//            result+=i;
//        }
//
//        for(int j=0;  j<nums.length; j++) {
//            result-=nums[j];
//        }

//        System.out.println(Math.abs(result));

        for(int num : nums) {
            int idx = Math.abs(num);
            if(nums[idx] < 0) {
                System.out.println(Math.abs(num));
                break;
            }
            nums[idx] = -nums[idx];
        }
    }
}

package com.example.Top150.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;

        k%= nums.length;

        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);

//       while(k>0) {
//            int j= 0;
//            int lastElem = nums[nums.length-1];
//            j+=1;
//            for(int i = nums.length-j-1; i>=0;i-- ) {
//                nums[i+1]= nums[i];
//            }
//            nums[0] = lastElem;
//            k--;
//        }
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void reverse(int nums[], int left , int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }
}

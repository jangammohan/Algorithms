package com.example.facebook;

public class NextPermutation {
    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        //int index =-1;
        int n = nums.length-2;
        while(n>=0 && nums[n] >= nums[n+1]){
            n--;
        }

        if(n>=0) {

            int j = nums.length -1;

            while(nums[j] <= nums[n]  ) {
                j--;
            }
            swap(nums, n, j);

        }
        reverse(nums, n+1);
    }

    public void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }

    public void reverse(int nums[], int start) {
        int n = nums.length-1;

        while(start < n) {
            swap(nums, start, n);
            start++;
            n--;
        }
    }
}

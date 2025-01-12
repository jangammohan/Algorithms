package com.example.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {

    public static void main(String[] args) {
        int nums[] = {3,1,2,4};
        int k =2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length-k];
    }

    public static int quickSort(int nums[], int low, int high, int k) {


            int pivotal = partition(nums, low, high);

            if(pivotal == k) {
                return nums[k];
            }
            if(  k < pivotal) {
               return quickSort(nums, low, pivotal-1, k);
            }else {

                return quickSort(nums, pivotal + 1, high, k);
            }

    }

    public static int partition(int nums[], int low, int high) {

            int pivotal = nums[high];
            int lowInd = low;
            for(int i = low; i<= high-1; i++) {
                if(nums[i] < pivotal) {

                    swap(nums, lowInd, i );
                    lowInd++;
                }
            }

            swap(nums, lowInd, high);
            return lowInd;

        }

    public static void swap(int nums[], int aInd, int bInd ) {
        int temp = nums[aInd];
        nums[aInd] = nums[bInd];
        nums[bInd] = temp;
    }
}

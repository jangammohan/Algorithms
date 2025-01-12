package com.example.facebook;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1};
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }

    //Leet code logic
    public static int longestOnes(int[] nums, int k) {
        int i =0;
        int j =0;
        for(; j<nums.length; j++) {
            if(nums[j] == 0 ){
                k--;
            }
            if(k<0 && nums[i++] == 0) {
                k++;
            }
        }

        return j-i;
    }


    public int myLongestOne(int nums[], int k) {

        int start = 0;
        int result = 0;
        for(int i =0 ; i<nums.length; i++) {
            if(nums[i] == 0 ) {
                k--;
            }

            while(k<0) {
                if(nums[start] ==0) {
                    k++;
                }
                start++;
            }

            result = Math.max(i-start+1, result);


        }
        return result;
    }
}

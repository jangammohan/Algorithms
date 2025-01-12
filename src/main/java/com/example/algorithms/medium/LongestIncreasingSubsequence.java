package com.example.algorithms.medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static void main(String args[]) {
        int[] nums = {1,3,6,7,9,4,10,5,6};//{10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        List<Integer> arrayList = new ArrayList();


        arrayList.add(nums[0]);
        for(int i =1; i<nums.length; i++) {
            if((arrayList.get(arrayList.size()-1) < nums[i])  ) {
                arrayList.add(nums[i]);

            }else {
                int j= binarySearch(arrayList,nums[i]);//0;
//                while(nums[i] > arrayList.get(j)) {
//                    j++;
//                }
                arrayList.set(j, nums[i]);
            }

        }


        System.out.println(arrayList);
        return arrayList.size();
    }

    public static int binarySearch(List<Integer> numList, int target) {
        int left =0;
        int right = numList.size() -1;

        while(left < right) {

            int mid = (left + right) / 2 ;

            if(numList.get(mid) < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return left;

    }
}

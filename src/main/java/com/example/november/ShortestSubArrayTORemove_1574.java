package com.example.november;

import java.sql.SQLOutput;

public class ShortestSubArrayTORemove_1574 {

    public static void main(String[] args) {
        ShortestSubArrayTORemove_1574 sh = new ShortestSubArrayTORemove_1574();
        System.out.println(sh.findLengthOfShortestSubarray(new int[]{1,2,3}));
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int res =0;
        //int curMaxInd = 0;
        for(int i =1;i<arr.length;i++) {
            if(!(arr[i] >= arr[i-1])) {
               // res++;
                int temp = i;
                while(temp>0 && !(arr[i] >= arr[temp-1])) {
                    temp--;
                }
                res = i -  temp;
            }
        }

        return res;
    }


    //Leetcode Solutions

    public int findLengthOfShortestSubarrayLeet(int[] arr) {

        int left =0;
        int n = arr.length;
        while(left < n-1 && arr[left+1] >= arr[left]) {
            left++;
        }

        if(left == n-1) {
            return 0;
        }

        int right = n-1;
        while(right>0 && arr[right]>= arr[right-1] ){
            right--;
        }

        int res = Math.min(n-left-1, right);

        int i = 0;
        int j = right;

        while(i<=left && j<n) {
            if(arr[i] <= arr[j]){
                res = Math.min(res, j-i-1);
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}

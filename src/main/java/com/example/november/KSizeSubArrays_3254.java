package com.example.november;

import java.util.Arrays;

public class KSizeSubArrays_3254 {
    public static void main(String[] args) {
        KSizeSubArrays_3254 k = new KSizeSubArrays_3254();
        int[] res = k.resultsArray(new int[]{1,2,3,4,3,2,5}, 3);
        Arrays.stream(res).forEach(System.out::println);
    }
    public int[] resultsArray(int[] nums, int k) {
        int res[] = new int[nums.length-(k-1)];
        int start = 0;
        int subArrayInd = k-1;

        for(; start+subArrayInd < nums.length; start++) {
            int temp = start;
            while (temp < start+subArrayInd  && nums[temp] +1 == nums[temp+1] ) {
                temp++;
            }
            if(temp == start+subArrayInd ) {
                res[start] = nums[start+subArrayInd ];

            }else {
                res[start] = -1;
            }


        }

        while (start < res.length) {
            res[start++] =-1;
        }



        return res;
    }
}

package com.example.amazon.medium;

import java.util.Arrays;

public class LengthOfSubArrayWithPositiveProduct {
    public static void main(String[] args) {
        int nums[] = {0,1,-2,-3,-4};

        //Arrays.sort(nums);
        int current  =1;
        int maxSoFar = nums[0];
        int result = 1;
        for (int j =0; j < nums.length ; j++) {
            if(nums[j] ==0 ) {
                continue;
            }
             current = nums[j] * current;
            if(current > maxSoFar) {
                maxSoFar = current;

                result+= ((j+1)-result) ;
            }
        }

        System.out.println( result );
    }

    public int CorrectSolution(int nums[]) {
        int pos =0, neg =0;
        int res =0;

        for(int num : nums) {

            if(num == 0) {
                pos =0;
                neg =0;
                continue;
            }
            pos++;
            neg = neg ==0 ? 0 : neg+1;
            if(num  < 0) {
                int temp = pos;
                pos = neg;
                neg = temp;
            }
            res = Math.max(res, pos);
        }

        return (res);
    }

}

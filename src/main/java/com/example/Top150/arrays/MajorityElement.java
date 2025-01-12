package com.example.Top150.arrays;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        if(nums.length == 1) {
           // return nums[0];
        }
       // Arrays.sort(nums);

       // System.out.println( nums[nums.length/2]);

        MajorityElement element = new MajorityElement();
        System.out.println( element.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {

        int ans = nums[0];
        int count = 1;

        for (int i=1; i<nums.length; i++) {
                if(ans == nums[i]) {
                    count++;
                } else {
                    count--;
                }

                if(count == 0) {
                    count = 1;
                    ans= nums[i];
                }
        }


        return ans;

    }
}

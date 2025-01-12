package com.example.Top150.twopointers;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result ;
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);
        for(int i =0 ; i<nums.length-2;i++) {
            int j = i+1;
            int k = nums.length-1;

            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if( sum == 0) {

                    set.add(new ArrayList<>(Arrays.asList(nums[i], nums[j++], nums[k--])));
                } else if(sum < 0) {
                    j++;
                }else {
                    k--;
                }

            }
        }

        result= new ArrayList<>(set);

        result.forEach(ls -> {
            ls.forEach(System.out::print);
        });
    }
}

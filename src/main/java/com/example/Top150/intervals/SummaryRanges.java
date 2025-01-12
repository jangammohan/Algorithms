package com.example.Top150.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {

        int[] nums = {0,2,3,4,6,8,9};

        List<String> res = new ArrayList<>();

        for(int i=0; i<nums.length;i++) {
            int start = i;
            while( i+1 < nums.length &&  nums[i]+1 == nums[i+1]) {
                i++;
            }
            if(i != start){
                res.add(nums[start]+"->"+nums[i]);
            } else {
                res.add(nums[start]+"");

            }

        }

        res.forEach(System.out::println);
    }
}

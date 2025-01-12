package com.example.Top150.HashSet;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};

        Arrays.sort(nums);
        int result =1;
        int rs = 0;
        for(int i =1; i<nums.length ;  i++) {
            if(nums[i-1] == nums[i]-1 ){
                result++;
                rs = Math.max(rs, result);
            }else {
            result =1;
            }
        }

        System.out.println(rs);
    }

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int a : nums) {
         set.add(a);
        }
        int result =0;
        for(int a : nums) {
            int count =1;
            if(!set.contains(a-1)) {
                while(set.contains(a+count)){
                    count++;
                }

            }
            result = Math.max(result, count);
        }
        return result;
    }

    // leetcode

    public int longleetCod(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max =0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            // look left
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);
        }

        return max;
    }
}

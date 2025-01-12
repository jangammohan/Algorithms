package com.example.september.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubArraySum {

    public static void main(String[] args) {
        ContinuousSubArraySum sum = new ContinuousSubArraySum();

        System.out.println(sum.checkSubarray(new int[]{1,3,6,0,9,6,9}, 7));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
       // boolean res = false;

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
       for (int i = 0 ; i < nums.length; i++) {
            sum+= nums[i];

            int remainder  = sum % k;
            if(map.containsKey(remainder)) {
                if(i-map.get(remainder) > 1) {
                    return true;
                }
            } else {
            map.put(remainder, i);
            }
       }
       return false;
    }

    //leetcode minimized solution

    public boolean checkSubarray(int[] nums, int k) {
        // boolean res = false;

        int sum = 0;
        int prev = 0;
        Set<Integer> set = new HashSet<>();
        //map.put(0, -1);
        for (int i = 0 ; i < nums.length; i++) {
            sum+= nums[i];

            if(set.contains(sum %k)) {
                return true;
            }
            set.add(prev);

             prev  = sum % k;

        }
        return false;
    }
}

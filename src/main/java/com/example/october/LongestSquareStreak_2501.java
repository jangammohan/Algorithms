package com.example.october;

import java.util.*;

public class LongestSquareStreak_2501 {
    public static void main(String[] args) {
        LongestSquareStreak_2501 lng = new LongestSquareStreak_2501();
        System.out.println(lng.longestSquareStreak(new int[]{4,3,6,16,8,2}));
    }
    public int longestSquareStreak(int[] nums) {

        Map<Integer, Integer > map = new HashMap<>();

        Arrays.sort(nums);
        int result = -1;
        for(int a : nums) {
            int temp = (int)Math.sqrt(a);
            if(temp*temp == a && map.containsKey(temp)) {
                map.put(a, map.get(temp)+1);
                result = Math.max(result, map.get(a));
            } else {
                map.put(a,1);
            }

        }

        return result;
    }



}

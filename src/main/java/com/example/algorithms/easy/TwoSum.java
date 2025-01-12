package com.example.algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int nums[] = {3,2,4};//{2,7,11,15};
        int target = 6;//9;
        int[] result = twoSum(nums, target);
        Arrays.stream(result).forEach(num-> System.out.println(num));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSum = new HashMap<>();
        int[] result = new int[2];
        for(int i =0; i < nums.length; i++) {

            if(twoSum.containsKey(nums[i])) {
                result[0] = twoSum.get(nums[i]);
                result[1] = i;
                break;
            }
            int sumDiff = target - nums[i];
            twoSum.put(sumDiff, i);
        }


        return result;
    }
}

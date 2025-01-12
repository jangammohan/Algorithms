package com.example.september.array;

import java.util.*;

public class SlidingSubArrayBeauty_2653 {

    public static void main(String[] args) {
        SlidingSubArrayBeauty_2653 beauty = new SlidingSubArrayBeauty_2653();
        int[] nums = {1,-1,-3,-2,3};
        int[] res = beauty.getSubarrayBeauty(nums, 3, 2);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        Map<Integer, Integer> map = new TreeMap<>() ;

        int res[] = new int[nums.length-k+1];
        int count = 0;
        for(int i =0 ; i <k;i++) {

                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        res[count++] = findKSamllest(map, x);

        for(int i =k; i<nums.length; i++) {

                map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            map.put(nums[i-k], map.get(nums[i-k])-1);

            if(map.get(nums[i-k]) == 0) {
                map.remove(nums[i-k]);
            }

            res[count++] = findKSamllest(map, x);
        }


        return res;
    }

    private int findKSamllest(Map<Integer, Integer> map, int find) {

        int count =0;
        for(Integer val : map.keySet()) {
            if(val < 0) {
                count+= map.getOrDefault(val, 0);
            } else {
                break;
            }

            if(count >= find) {
                return val;
            }
        }

        return 0;

    }
}

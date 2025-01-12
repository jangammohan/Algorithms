package com.example.Top150.HashSet;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k =3;
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i =0; i<nums.length;i++) {
            if(indexMap.get(nums[i]) != null && i - indexMap.get(nums[i]) <= k) {
                System.out.println(true);
                return;
            }
            indexMap.put(nums[i],i);
        }
        System.out.println(false);
    }
}

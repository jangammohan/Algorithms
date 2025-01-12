package com.example.october;

import java.util.ArrayList;
import java.util.List;

public class SubSets_78 {

    public static void main(String[] args) {
        SubSets_78 sub = new SubSets_78();
        sub.subsets(new int[]{1,2,3});
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
         subsets(nums, 0, result, new ArrayList<>());
         result.forEach(System.out::println);
         return result;
    }

    public  void subsets(int[] nums, int start, List<List<Integer>> result, List<Integer> ls) {

       // List<Integer> temp = new ArrayList<>();
        result.add(new ArrayList<>(ls));
        for(int i = start; i<nums.length; i++) {
            ls.add(nums[i]);
            subsets(nums, i+1, result, ls);
            ls.remove(ls.size()-1);
        }

    }
}

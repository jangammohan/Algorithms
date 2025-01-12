package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target).toString());
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(candidates, target, 0, result, new ArrayList<>());

        return result;
    }

    public static void combinations(int[] candidates, int targetDiff, int start, List<List<Integer>> result, List<Integer> temp  ) {

        if(targetDiff < 0) {
            return;
        }
        else if(targetDiff == 0 ){
            result.add(new ArrayList<>(temp));

        } else {
            for(int i= start; i<candidates.length;i++){
                temp.add(candidates[i]);
                combinations(candidates, targetDiff- candidates[i], i, result, temp );
                temp.remove(temp.size() -1);
            }
        }

    }
}

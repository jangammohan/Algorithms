package com.example.september.array;

import java.util.Arrays;

public class PredictTheWinner_486 {



    public boolean predictTheWinner(int[] nums) {

        int p1Score = findP1CanWin(nums, 0, nums.length-1);
        int total = Arrays.stream(nums).sum();

        int memo[][] = new int[nums.length][nums.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return p1Score >= total-p1Score;
    }

    private int findP1CanWin(int[] nums, int start, int end ){

        if(start> end ) {
            return 0;
        }

        if(start ==end) {
            return nums[start];
        }

        int currScore = Math.max(nums[start] + Math.min(findP1CanWin(nums, start+2,end),
                findP1CanWin(nums, start+1, end-1)),

                nums[end]+ Math.min(findP1CanWin(nums, start+1,end-1),
                        findP1CanWin(nums, start+1, end-2)));
         return currScore;

        }


        //Recursion solution


    private boolean canWin(int nums[], int start, int end, int sum1, int sum2, int player, int[][] memo) {

        if(start > end) {
            return sum1 >= sum2;
        }



        if(start == end) {
            if(player == 1) {
                return sum1+nums[start]>= sum2;
            }else {
                return sum1<sum2+nums[start];
            }
        }

        if(player ==1) {
            return !canWin(nums, start+1, end, sum1+nums[start], sum2, 2, memo) ||
                    !canWin(nums, start, end-1, sum1+nums[end], sum2, 2, memo);
        }else {
            return !canWin(nums, start+1, end, sum1, sum2+nums[start], 1, memo) ||
                    !canWin(nums, start, end-1, sum1, sum2+nums[end], 1, memo);
        }
    }

}

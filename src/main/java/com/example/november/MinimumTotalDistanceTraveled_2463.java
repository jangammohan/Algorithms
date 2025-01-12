package com.example.november;

import java.util.*;

public class MinimumTotalDistanceTraveled_2463 {
    public static void main(String[] args) {
        MinimumTotalDistanceTraveled_2463 min = new MinimumTotalDistanceTraveled_2463();
        System.out.println(min.leetMinimumTotalDistance(Arrays.asList(9,11,99,101),
                new int[][]{{10,1},{7,1},{14,1},{100,1},{96,1},{103,1}}));
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        long result = 0;
        Map<Integer, Integer> posLimit = new HashMap<>();
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));



        for(int[] fac : factory ) {
            posLimit.put(fac[0], fac[1]);

        }


        for(Integer val : robot) {
            int currentMinVal = Integer.MAX_VALUE;
            int currFacInd = -1;
            for(int i=0; i<factory.length; i++) {

                int diffVal = Math.abs(factory[i][0]-val);
                if(posLimit.get(factory[i][0]) > 0) {
                    if(currentMinVal > diffVal ) {
                        currentMinVal = diffVal;
                        currFacInd = i;
                    }

                }
            }
           if(currFacInd != -1) {
                result+= currentMinVal;
                posLimit.put(factory[currFacInd][0], posLimit.get(factory[currFacInd][0])-1);
           }
        }

        return result;
    }


    //LeetCode Solutions

    public long leetMinimumTotalDistance(List<Integer> robot, int[][] factory) {

        int m = robot.size();
        int n = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        long dp[][] = new long[m+1][n+1];

        for(int i =0 ;i<m;i++){
            dp[i][n] = Long.MAX_VALUE;
        }


        for(int j=n-1;j>=0;j--) {
            Deque<long[]> queue = new ArrayDeque<>();
            queue.offer(new long[]{m, 0});
            long prefix = 0;
            for(int i=m-1;i>=0;i--) {
                prefix+= Math.abs(robot.get(i) - factory[j][0]);

                while(!queue.isEmpty() && queue.peekFirst()[0] > i + factory[j][1]) {
                    queue.pollFirst();
                }

                while(!queue.isEmpty() && queue.peekLast()[1] >= dp[i][j+1] - prefix ) {
                    queue.pollLast();
                }
                queue.offerLast(new long[]{i, (dp[i][j+1] - prefix)});
                dp[i][j] = queue.peekFirst()[1] + prefix;

            }

        }
        return dp[0][0];
    }
}

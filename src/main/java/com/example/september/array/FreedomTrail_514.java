package com.example.september.array;

import java.util.HashMap;
import java.util.Map;

public class FreedomTrail_514 {
    public int findRotateSteps(String ring, String key) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(ring, key, 0, 0, memo);
    }

    private int dfs(String ring, String key, int keyInd, int ringIndex, Map<String, Integer> memo) {
        if (keyInd == key.length()) {
            return 0;
        }
        String memoKey = ringIndex + "," + keyInd;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        int minSteps = Integer.MAX_VALUE;
        char target = key.charAt(keyInd);

        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == target) {
                int diff = Math.abs(i - ringIndex);
                int antiClock = ring.length() - diff;
                int nextStep = 1 + dfs(ring, key, keyInd + 1, i, memo);
                minSteps = Math.min(nextStep, minSteps);
            }
        }
        memo.put(memoKey, minSteps);
        return minSteps;

    }


    //Another solution DP Memonization

    public int findRotateStepsDP(String ring, String key) {

        int rLeng = ring.length();
        int kLen = key.length();

        int dp[][] = new int[rLeng][kLen];

        for (int i = kLen - 1; i > 0; i--) {

            for (int j = 0; j < rLeng; j++) {
                for (int k = 0; k < rLeng; k++) {

                    if (ring.charAt(k) == key.charAt(i)) {

                        int diff = Math.abs(i - j);
                        int rotate = Math.min(diff, rLeng - diff);
                        int total = rotate + 1 + dp[k][i + 1];
                        //dp[i][j] = rotate+

                    }
                }

            }



        }
        return 0;
    }
}

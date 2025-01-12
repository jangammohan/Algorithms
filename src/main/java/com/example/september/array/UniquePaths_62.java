package com.example.september.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniquePaths_62 {

    public static void main(String[] args) {
        UniquePaths_62 unique = new UniquePaths_62();
        Map<String, Integer> map = new HashMap<>();
        System.out.println(unique.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n, Map<String, Integer> map) {

        if(m==1 && n==1){
            return 1;
        }

        if(m==0 || n==0) {
            return 0;
        }
        String key = m+","+n;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int temp = uniquePaths(m-1,n, map) + uniquePaths(m, n-1, map);
        map.put(key, temp);
        return temp;

    }


    // Using tabulization

    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        Arrays.fill(dp[0],1);
        for(int i=0; i<m; i++) {
            dp[i][0]= 1;
        }

        for(int i =1 ; i<m; i++) {
            for (int j=1 ; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

package com.example.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

public class EncodeString {

    public static void main(String args[]) {
        String s = "aabcaabcd"; //"aaa";
        System.out.println(encode(s));
    }

    public static String encode(String s) {

        String dp[][] = new String[s.length()][s.length()];
        if(s.length() < 5) {
            return s;
        }

        for(int i=1;i<= s.length();i++) {
            for(int j=0; j <= s.length()-i; j++) {
                int end = j+i-1;
                String temp =  s.substring(j,end+1);
                if(i < 5) {

                    dp[j][end] = temp;
                    continue;
                }

                int repeatPos = (temp + temp).indexOf(temp,1);
                if(repeatPos < temp.length()) {
                    temp = Integer.toString(temp.length()/repeatPos) + "[" + dp[j][j+repeatPos -1] + "]";
                }

                for(int p = j; p<end; p++) {
                    if(dp[j][p].length() + dp[p+1][end].length() < temp.length()) {
                        temp = dp[j][p]+ dp[p+1][end];
                    }
                }
                dp[j][end] = temp;
            }
        }

        return dp[0][s.length()-1];
    }
}

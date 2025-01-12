package com.example.Top150.arrays;

public class LongestCommonSubsequence {



    public static void main(String[] args) {

        LongestCommonSubsequence lg = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        Integer dp[][] = new Integer[text1.length()][text2.length()];
        //System.out.print(lg.LCS("abcde","ace",0,0, dp));

        System.out.print(lg.longTopBottomApproach(text1,text2));
    }
// DP - Bottom UP Approach
    public int LCS(String text1,String text2, int i, int j, Integer dp[][] ) {
        if(i == text1.length() || j == text2.length()) {
            return 0;
        }
        if(dp[i][j]!= null) {
            return dp[i][j];
        }
         else if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1+LCS(text1, text2, i+1, j+1, dp);
            return dp[i][j];
        }else {
            dp[i][j]= Math.max(LCS(text1, text2, i+1,j,dp), LCS(text1,text2, i,j+1, dp));
            return dp[i][j];
        }
    }


    //DP -TOP Bottom Approach

    public int longTopBottomApproach(String text1,String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=1; i<=text1.length();i++) {
            for(int j=1; j<= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}

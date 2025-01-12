package com.example.Top150.arrays;

public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "eee";
        int maxLen = Integer.MIN_VALUE;
          int index = 0;

          while (index < s.length()) {

              int left = index;
              int right = index;
              char c = s.charAt(index);

              while (left >= 0 && s.charAt(left) == c) {
                  left--;

              }

              while (right < s.length() && s.charAt(right) == c) {
                  right++;

              }

              while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                  left--;
                  right++;
              }

              maxLen = Math.max(maxLen, right - (left + 1));
              index++;
          }

        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {


        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n;i++) {
            dp[i][i] =1;
        }

        for(int i=0,j= 1; j<n;i++,j++){
            dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 1;
        }


        for(int len = 2; len <n; len++) {

            for(int i=0, j= len; j<n;i++,j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2+dp[i+1][j-1];
                }else {
                    dp[i][j]  = Math.max(dp[i][j-1], dp[i+1][j]);;
                }

            }
        }

        return dp[0][n-1];
    }
}

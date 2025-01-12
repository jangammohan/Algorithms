package com.example.november;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberSameEndSubstrings_2955 {

    // Fails in duplicate entry use cases.
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int result[] = new int[queries.length];
    int index =0;
        for(int[] val : queries ) {
            int res =0;
            String temp = s.substring(val[0], val[1]+1);
            int len = temp.length();
            res+=len;
            if(len > 1) {
                Map<Character, Integer> map = new HashMap<>();
                for(int i =0; i< len; i++) {
                    if(map.containsKey(temp.charAt(i))) {
                        if(i-map.get(temp.charAt(i)) > 1) {
                            res++; }
                    } else {
                        map.put(temp.charAt(i),i);
                    }

                    if (i>0 && temp.charAt(i-1) == temp.charAt(i)  ) {
                        res++;
                    }

                }


            }
            result[index++] = res;

        }
        return result;
    }



    //Leet solution
    public int[] sameEndSubstringCountLeet(String s, int[][] queries) {

        int dp[][] = new int[s.length()][26];
        int ans[] = new int[queries.length];

        dp[0][s.charAt(0)-'a']++;
        int n = s.length();
        for(int i=1; i<n; i++) {
            dp[i] = Arrays.copyOf(dp[i-1], 26);
            dp[i][s.charAt(i)-'a']++;
        }
        int index =0;
        for(int[] val : queries) {
            int left = val[0];
            int right = val[1];

            for(int i =0; i<26; i++) {
                int count = dp[right][i] - (left == 0 ? 0 : dp[left-1][i]);
                ans[index]+= (count*(count-1))/2 + count;
            }
            index++;
        }

        return ans;

    }

}

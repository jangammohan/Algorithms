package com.example.Top150.arrays;

import java.util.HashMap;
import java.util.Map;

public class StringMinimumWindow {

    public static void main(String[] args) {
        System.out.print(minWindowHash("ADOBECODEBANC", "ABC"));

        System.out.println(lengthOfLongestSubstringTwoDistinct("ABCDEF"));
    }

    public static String minWindowHash(String s, String t) {

        Map<Character, Integer> tMap = new HashMap<>();

        for(char c: t.toCharArray()) {
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }

        int start = 0, end =0;
        int minLen = Integer.MAX_VALUE;
        int minStart =0;
        int counter = t.length();

        while(end<s.length()) {
            if(tMap.containsKey(s.charAt(end)) ) {
                if(tMap.get(s.charAt(end)) > 0)
                        counter--;

                tMap.computeIfPresent(s.charAt(end), (key, val)-> val-1);
            }
            end++;

            while(counter == 0 ) {
                if(minLen > end-start) {
                    minLen = end-start;
                    minStart = start;
                }

                if(tMap.containsKey(s.charAt(start))) {
                    tMap.computeIfPresent(s.charAt(start), (key, val)-> val+1);

                }

                if(tMap.getOrDefault(s.charAt(start),0) > 0) {
                    counter++;
                }
                start++;
            }
        }


       return (minLen == Integer.MAX_VALUE) ? "": s.substring(minStart, minStart+minLen);
    }


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > 2) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}

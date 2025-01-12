package com.example.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringNonRepeating {
    public static void main(String[] args) {

        String s = "pwwkew";

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();



        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

    System.out.println(max);
    }
}

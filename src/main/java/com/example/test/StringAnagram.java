package com.example.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class StringAnagram {

    public static void main(String args[]) {
        String s1 =   "abab";//"cbaebabacd";
        String s2 = "ab";//"abc";
        StringAnagram stringAnagram = new StringAnagram();
        stringAnagram.findAnagram( s1, s2);
    }

    public void findAnagram(String s1, String s2) {



        int s2_array[] = new int[26];

        for(char ch : s2.toCharArray()) {
            s2_array[ch - 'a']++;
        }

        for (int i=0; i <= s1.length() - s2.length(); i++) {
            int s1_array[] = new int[26];
            int j = i;
            for ( ; j< i+s2.length(); j++ ) {
                s1_array[s1.charAt(j) - 'a']++;
            }
            if(matches(s1_array, s2_array, i , j, s1) ) {
                System.out.println("Found Anagram at index -"+i +" ,substring - "+s1.substring(i,j));
            }

        }

    }

    public boolean matches(int[] s1, int[] s2, int i, int j, String str) {
       for (; i< j; i++){
           if(s2[str.charAt(i)-'a'] != s1[str.charAt(i)-'a']) {
               return false;
           }
       }
        return true;
    }
}

package com.example.algorithms.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String strs[] = {"reflower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length ==0 || strs[0].isEmpty() ) {
            return "";
        }
        if(strs.length==1) {
            return strs[0];
        }

        Arrays.sort(strs, (str1, str2) -> str1.compareTo(str2) );

        int len = Math.min(strs[0].length(), strs[1].length());
        int lastIndex = strs.length;
        int j = 0;
        while( j < len && strs[0].charAt(j) == strs[lastIndex-1].charAt(j)) {
            j++;
        }


        return  strs[0].substring(0, j) ;
    }

}

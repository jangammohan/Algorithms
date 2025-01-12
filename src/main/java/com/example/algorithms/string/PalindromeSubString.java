package com.example.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubString {

    static List<List<String>> result = new ArrayList<>();
    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }

    public static List<List<String>> partition(String s) {


        partitionString(s, 0, new ArrayList<>());

        System.out.println(result.toString());
        return result;
    }

    public static void partitionString(String s, int start, List<String> subList) {

        if(start == s.length()) {
            result.add(new ArrayList<>(subList));
        }
        else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i))
                {
                    subList.add(s.substring(start, i + 1));
                    partitionString(s, i + 1, subList);
                    subList.remove(subList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start < end  ) {
            if(s.charAt(start++) != s.charAt(end--) ) {
                return false;
            }
        }
        return true;

    }
}

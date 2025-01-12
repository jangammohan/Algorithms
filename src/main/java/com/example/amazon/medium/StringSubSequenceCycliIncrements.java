package com.example.amazon.medium;

public class StringSubSequenceCycliIncrements {
    public static void main(String[] args) {
        String s1 = "zc", s2 = "ad";

            if(s2.length() == 1) {
                System.out.println("true");
            }

            int result = 0;
            for(int j =0; j<s1.length() && result < s2.length(); j++) {
                if(s1.charAt(j) == s2.charAt(result) || ((s1.charAt(j)-'a' +1) %26) == (s2.charAt(result)-'a') ) {
                    result++;
                }

            }

            System.out.println(result == s2.length());
        }

}

package com.example.test;

import java.util.HashMap;

public class RegularExpressionMatching {

    public static void main(String args[]) {
        String str = "aa";
        String pattern = ".*";

        HashMap hs;

        if(str.length() != pattern.length()) {
            System.out.println("Pattern Not Matching - false");

        } else {
            char preceed = ' ';
            boolean patMat = true;
            for (int i =0 ; i< str.length(); i++) {

                if(pattern.charAt(i) == '.' ) {
                    preceed = pattern.charAt(i);

                }

                else if (pattern.charAt(i) == '*' &&
                        (preceed == str.charAt(i)  || preceed == '.' ) ){

                } else if(pattern.charAt(i) == str.charAt(i)) {
                    preceed = pattern.charAt(i);
                } else {
                    patMat = false;

                    break;
                }


            }

            if (patMat) {
                System.out.println("Pattern Matches");
            } else {
                System.out.println("Pattern did not Match");
            }
        }
    }
}

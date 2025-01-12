package com.example.test;

import java.util.Arrays;
import java.util.List;

public class StringPalindromeSubString {
    static  String str  = "forgeeksskeegfor";
    public static void main(String args[]) {


        int length = 0;
        String palStr = "";
        for(int i =0 ; i < str.length(); i++) {
            for(int j = i+1 ; j<str.length(); j++ ) {
                if(str.charAt(j) == str.charAt(i) && (j-i)+1 > palStr.length() ) {
                   String temp =   getPalindromeLength(i, j);
                   if(temp.length() > palStr.length()) {
                       palStr = temp;
                   }
                }
            }
        }
        System.out.println("Pal Str - "+palStr);

    }

    private static String getPalindromeLength(int a, int b) {
        int ain = a+1;
        int bin = b-1;
        if(ain == bin || ain > bin) {
            return str.substring(a,b+1);
        }

        while (ain < bin  ) {

            if(str.charAt(ain) == str.charAt(bin)) {
                ain++;
                bin--;
                continue;

            } else {
                return "";
            }

        }
        return str.substring(a,b+1);
    }
}

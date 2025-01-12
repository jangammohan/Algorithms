package com.example.Top150.twopointers;

import java.util.Locale;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = " ";
        s = s.toLowerCase();
        int start =0;
        int end = s.length()-1;

        while(start<end ) {

            if(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start)) ){
                start++;
            }else if(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end)) ) {
                end--;
            }
            else if(s.charAt(start++) == s.charAt(end--)) {
                continue;

            }else {
                System.out.println("false");
                break;
            }
        }
        System.out.println(true);
    }
}

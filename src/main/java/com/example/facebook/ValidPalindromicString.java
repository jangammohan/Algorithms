package com.example.facebook;

public class ValidPalindromicString {

    static int result =  0;

    int count = 0;

    public static void main(String[] args) {

        String s = "aaa";
         //s.length();

//        for (int i = 0; i < s.length(); i++) {
//            if(isPalindrome(s.substring(0, i+1))){
//                result++;
//            }
//        }
        stringIterate(s, 0,"");
        System.out.println(result);
    }

    public static void stringIterate(String s, int ind, String current) {
        if (current.length() > 0 && isPalindrome(current)) {
            result++;
        }

        for (int i = ind; i < s.length(); i++) {
            stringIterate(s, i + 1, current + s.charAt(i));
        }
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int end = s.length() - 1;
        if(i==end) {
            return true;
        }
        while (i < end) {
            if (s.charAt(i++) == s.charAt(end--)) {
                continue;
            } else {
                return false;
            }

        }
       return true;
    }


    //leet code logic

    public int countSubstrings(String s) {

        for(int i=0; i< s.length(); i++) {
            isPalindrome(s, i,i);
            isPalindrome(s, i, i+1);
        }
        return count;
    }

    public void isPalindrome(String s, int start, int end) {
        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end) ){
            count++;
            start--;
            end++;
        }

    }

}


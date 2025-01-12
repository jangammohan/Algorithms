package com.example.facebook;

public class ValidWordAbbreviation {

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {

        if(word == null || abbr == null) return false;
        int num = 0;
        int idx = 0;

        for(char c: abbr.toCharArray()){
            if(c == '0' && num == 0) return false;
            if(c >= '0' && c <= '9'){
                num = num*10 + (c-'0');
            }else{
                idx += num;
                if(idx >= word.length() || c != word.charAt(idx)) return false;
                num = 0;
                idx++;
            }
        }

        return idx+num == word.length() ? true : false;

    }

}

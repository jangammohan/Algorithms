package com.example.Top150.HashSet;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        String strArr[] = s.split(" ");

        for(int i =0; i<pattern.length() ; i++) {
            if(pMap.get(pattern.charAt(i)) == null) {
                pMap.put(pattern.charAt(i), strArr[i]);
            }
            if(sMap.get(pattern.charAt(i)) == null) {
                sMap.put(strArr[i], pattern.charAt(i));
            }

        }

        if(pMap.size() != sMap.size() ) {
            System.out.print(false);
            return;
        }

        for(int i =0;i<pattern.length(); i++) {
            System.out.print(pMap.get(pattern.charAt(i)));
            System.out.println(strArr[i]);
            if(!pMap.get(pattern.charAt(i)).equals( strArr[i]) ) {
                System.out.print(false);
                return;
            }

        }
        System.out.print(true);
    }
}

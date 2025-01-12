package com.example.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    public static void main(String[] args) {

        String s = "code";
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(set.contains(c)){
                set.remove(c);
            } else {
                set.add(c);
            }
        }


        System.out.println(set.size() > 1 ? false : true);
    }
}

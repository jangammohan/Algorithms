package com.example.Top150.HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "cat";

        if(s.length() != t.length()) {
            System.out.println( false);
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(char c : t.toCharArray()) {
            if(map.get(c) == null) {
                System.out.println(false);
                return;
            } else {
                if(map.get(c) == 0){
                    System.out.println(false);
                    return;
                }
                map.put(c, map.get(c)-1);
            }
        }

        System.out.println(true);
    }
}

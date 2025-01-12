package com.example.Top150.HashSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : ransomNote.toCharArray()) {

         Integer newVal =    map.computeIfPresent( ch, (key, val)->{
                return val+1;
            });
         if(newVal == null ) {
            map.computeIfAbsent(ch, (ch1)-> 1 );
         }
        }

        for(char ch : magazine.toCharArray()) {
            map.computeIfPresent( ch, (key, val)->{
                return val-1;
            });
        }

        for(Character c : map.keySet()) {
            if(map.get(c) > 0) {
                System.out.print(false);
                return;
            }
        }
        System.out.print(true);
    }
}

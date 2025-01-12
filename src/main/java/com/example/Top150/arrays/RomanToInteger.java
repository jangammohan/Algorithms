package com.example.Top150.arrays;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV", 4);
        map.put("V",5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);map.put("XC", 90);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);map.put("CD", 400);
        map.put("CM", 900);


        String s = "III";
        int result = 0;
        int prev =0;
        for( int i=0; i<s.length(); i++) {
            if( i<s.length()-1 ){
                char next = s.charAt(i+1);
                char current = s.charAt(i);
                if( (current== 'I' && next == 'V') || (current== 'I' && next == 'X') || ( current== 'X' && next == 'L') || (current== 'X' && next == 'C')
                        || (current== 'C' && next == 'D') ||(current== 'C' && next == 'M') ) {
                    i++;
                }
            }
            String str = s.substring(prev, i+1);
            result = result+ map.get(str);
            prev = i+1;
        }
      System.out.print(result);
    }
}

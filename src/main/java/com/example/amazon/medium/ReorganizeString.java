package com.example.amazon.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    static String s = "vvvlo"; // "aab";
    public static void main(String[] args) {



       Map<Character, Integer> map = new HashMap<>();
       int maxCharCount =0;
       char maxChar = ' ';

       for(char c : s.toCharArray()) {
           map.put(c, map.getOrDefault(c,0)+1);
           if(map.get(c) > maxCharCount) {
               maxChar = c;
               maxCharCount = map.get(c);
           }
       }

       if( maxCharCount > (s.length()+1)/2){
           System.out.print("");
           return;
       }

       int idx =0;
       char result[] = new char[s.length()];
       while(idx < s.length() && maxCharCount >0) {
           result[idx] = maxChar;
           maxCharCount = maxCharCount-1;
           map.put(maxChar, maxCharCount);
           idx+= 2;
       }


       for(char c : map.keySet()) {

           while(map.get(c) > 0) {

               if(idx >= s.length()) {
                   idx =1;
               }
               result[idx] = c;
               map.put(c,map.get(c)-1);
                idx+=2;
           }


       }

       System.out.println(new String(result));


    }


}

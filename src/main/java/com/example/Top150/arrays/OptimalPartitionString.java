package com.example.Top150.arrays;

import java.util.*;

public class OptimalPartitionString {

    public static void main(String[] args) {
        OptimalPartitionString op = new OptimalPartitionString();
       System.out.print( op.longestSubstring("aaabb", 3) );
    }

    public int partitionString(String s) {
       Set<Character> set = new HashSet<>();
       int index =0;
       int count =0;
       while (index < s.length()) {
           if(set.contains(s.charAt(index))) {
                count++;
                set.clear();
           }

           set.add(s.charAt(index));
           index++;
       }
        return count+1;
    }
/// Longets Substring With Atleast K Repeating Characters.

    public int longestSubstring(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();



       int index =0;
        int counter =0;
        int start =0;
        while(index < s.length()) {

          map.put(s.charAt(index), map.getOrDefault(s.charAt(index),0)+1);

          if(map.get(s.charAt(index)) >= k){
              counter++;
          }

          while(counter > 0) {
              if(map.get(s.charAt(start)) >=k){

              }
          }

            index++;
        }



        return  0;
    }

}

package com.example.test;

import java.util.HashMap;

public class LongestSubString {

    public static void main(String... args) {
        String input = "abcabcbb" ;//"bbbbb" ; // "abcabcbb";  //

        int subStringLen = 0;
        int soFar = 1;



        //if (input.length()==0)

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<input.length(); ++i){
            if (map.containsKey(input.charAt(i))){
                j = Math.max(j,map.get(input.charAt(i))+1);
            }
            map.put(input.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        System.out.println(max);



//        for (int i =1 ; i < input.length() ; i++) {
//
//            String currentSubstring = input.substring(subStringLen, i);
//            if(   currentSubstring.indexOf(input.charAt(i)) < 0   ) {
//                soFar++;
//
//            } else if(soFar < subStringLen) {
//                soFar++;
//            }
//
//            else {
//                if( soFar > subStringLen ) {
//                    subStringLen = soFar;
//                }
//                soFar = 1;
//            }
//
//        }
//
//        if( soFar > subStringLen ) {
//            subStringLen = soFar;
//        }


    }
}

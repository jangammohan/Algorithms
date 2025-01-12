package com.example.september.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSpecialSubString_2981 {

    public static void main(String[] args) {
        LongestSpecialSubString_2981 longest = new LongestSpecialSubString_2981();
        System.out.println(longest.maxLen("aaabbbaa"));

    }


    //Leet Code solution

    public int maxLen(String st) {
        int res = -1;
       Map<String, Integer> map = new HashMap<>();

       for(int i =0 ; i< st.length(); i++) {
           //int count =0;
           String temp = st.substring(i, i+1);
           map.put(temp, map.getOrDefault(temp, 0)+1);
           int j = i+1;
           while(j<st.length() && st.charAt(j) == st.charAt(j-1) ) {
               temp = st.substring(i, j+1);

               map.put(temp, map.getOrDefault(temp, 0)+1);
               j++;
           }

           for(Map.Entry<String, Integer> entry : map.entrySet()) {

               if(entry.getValue() >= 3){
                   res = Math.max(res, entry.getKey().length());
               }
           }


       }

        return res;
    }


    public int maximumLength(String s) {

        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        int count =0;

        int res = Integer.MIN_VALUE;
        for(int i =0; i< len; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=i; j<=len; j++) {
                String temp = sb.append(s.charAt(i)).toString();
                map.put(temp, map.getOrDefault(temp, 0)+1);
                if(map.get(temp) >= 3) {



                    if(map.get(temp) > count ) {
                        count = map.get(temp);
                        res = temp.length();
                    }
                    // res = Math.max(res, temp.length());
                }

            }

        }

        //System.out.println(map.get("cd"));
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}

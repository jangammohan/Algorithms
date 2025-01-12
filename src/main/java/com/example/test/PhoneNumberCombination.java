package com.example.test;

import java.util.HashMap;

public class PhoneNumberCombination {

   static HashMap<String, String> hmap = new HashMap();

    static String inputString = "23";
    public static void main(String args[]) {
        hmap.put("2", "abc");
        hmap.put("3", "def");
        hmap.put("4", "ghi");
        hmap.put("5", "jkl");
        hmap.put("6", "mno");
        hmap.put("7", "pqrs");
        hmap.put("8", "tuv");
        hmap.put("9", "wxyz");

        String temp ="";
        int charIndex = 0;
        int maxLength = 0;

        phCombination(hmap, 0, "", "", inputString);

//        for (int i=0; i< inputString.length(); i++) {
//
//            String data = hmap.get(""+inputString.charAt(i));
//
//            maxLength = data.length();
//            if(data.length() > 0  ) {
//                temp += data.charAt(charIndex);
//            }
//
//            if(temp.length() == inputString.length()) {
//
//                System.out.println(temp);
////                stringPermutation(temp.toCharArray(), 0 , temp.length()-1);
////                temp="";
////                charIndex++;
////                if(charIndex < maxLength) {
////                    i =-1;
////                }
//
//            }
//
//
//
//
//        }


    }


    public static void phCombination(HashMap<String, String> hs, int start, String temp, String hString, String inputString ) {


        if(temp.length() == inputString.length() && !temp.isEmpty()) {
            System.out.println(temp);
            return;
        }

        if(start == inputString.length()){
            return;
        }

             hString = hs.get(""+inputString.charAt(start));
            String currentTemp = temp;
            currentTemp += ""+hString.charAt(0);

             phCombination(hs, start+1, currentTemp, hString, inputString );

             for(int i = 1; i< hString.length(); i++) {
                  currentTemp = temp;
                 currentTemp += ""+hString.charAt(i);
                 phCombination(hs, start+1, currentTemp, hString, inputString );
             }

    }

    public static void stringPermutation(char[] str, int start, int end) {
            if (start == end){
                System.out.println(str);
            }

            for (int i =start ; i < str.length; i++) {
                swap(str, start, i);
                stringPermutation(str, start+1, end);
                swap(str, start, i);

            }
    }

    public static void swap(char[] str, int start, int end) {
        char tempCh = str[start];
        str[start] = str[end];
        str[end] = tempCh;
    }
}

package com.example.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {

        String result = countRecursive(n);
        return result;
    }

    public static String countRecursive(int n) {

        if(n == 1) {
            return "1";
        }

        String temp = countRecursive(n-1);

        StringBuilder stringBuilder = new StringBuilder("");
        char c = temp.charAt(0);
        int count =1;
        for(int i =1 ; i < temp.length() ; i++) {

            if(c != temp.charAt(i)){
             stringBuilder.append(count).append(c);
             c = temp.charAt(i);
             count =1;
            } else {
            count++;
            }
        }
        stringBuilder.append(count).append(c);

        return stringBuilder.toString();


    }
}

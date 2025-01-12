package com.example.algorithms.easy;

import java.util.HashMap;

public class Logger {

    static HashMap<String, Integer> hs = new HashMap<>();
    public static void main(String args[]) {
       System.out.println( shouldPrintMessage(1, "foo") );
        System.out.println( shouldPrintMessage(11, "foo") );


    }

    public static boolean shouldPrintMessage(int timestamp, String message) {

        if(hs.containsKey(message)) {
            if(timestamp < hs.get(message) ) {
                return false;
            }
        }
        hs.put(message, timestamp+10);
        return true;
    }
}

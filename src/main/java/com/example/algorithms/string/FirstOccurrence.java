package com.example.algorithms.string;

public class FirstOccurrence {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "pad";
        int result = haystack.indexOf(needle, 0);
       System.out.println(result);
    }
}

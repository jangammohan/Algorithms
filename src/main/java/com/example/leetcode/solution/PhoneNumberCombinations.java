package com.example.leetcode.solution;

import java.util.LinkedList;

public class PhoneNumberCombinations {
    public static void main(String args[]) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        String digits = "234";

        if(digits.isEmpty()) {
            return ;
        }
        LinkedList<String> results =  new LinkedList<>();
        results.add("");
        for (int i =0 ; i < digits.length() ; i++ ) {

            while(results.peek().length() == i ) {

                String remove = results.remove();

                for(char a : mapping[Character.getNumericValue(digits.charAt(i))].toCharArray() ) {
                    results.add(remove+a);
                }

            }

        }

        System.out.println(results);


    }

}

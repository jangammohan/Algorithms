package com.example.facebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombinationUsingRecurrsion {
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void main(String[] args) {
        PhoneNumberCombinationUsingRecurrsion p = new PhoneNumberCombinationUsingRecurrsion();
        p.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {

    List<String> results = new ArrayList<>();
        stringRecurrsion(digits, "", results);
        System.out.println(results.toString());
        return null;
    }

    public void stringRecurrsion(String digits, String current,  List<String> res) {

        if(digits.isEmpty()) {
            res.add(current);
        }
        else {

                String currentDigitStr = mapping[digits.charAt(0)-'0'];
                for(int j=0; j<currentDigitStr.length(); j++) {
                    stringRecurrsion(digits.substring(1), current+currentDigitStr.charAt(j), res);
                }

        }
    }

}

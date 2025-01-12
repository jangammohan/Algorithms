package com.example.amazon.medium;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("123456789", "987654321"));
    }
    public static String multiply(String num1, String num2) {

        int str1Number = 0;
        int str2Number = 0;
        for (char c : num1.toCharArray()) {
            str1Number = (str1Number *10) + c - 48;
        }

        for (char c : num2.toCharArray()) {
            str2Number = (str2Number *10) +  c - 48;
        }
        int prod = str1Number * str2Number;

        StringBuilder result = new StringBuilder();

        while(prod > 0) {
            int last = prod%10;
            result.append(last);
            prod = prod/10;
        }

        System.out.println(result.toString());

       return result.reverse().toString();
    }

}

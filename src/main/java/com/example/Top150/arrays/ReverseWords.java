package com.example.Top150.arrays;

import java.util.Stack;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "a good   example";
        s = s.trim();

        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int start =0;
        int i = 0;
        for(;i<s.length(); ){
            if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                i++;
            }else {

                stack.push(s.substring(start, i));

                while(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i)) ) {
                    i++;
                }
                start = i;
            }
        }
        if(s.length() > 1) {
            stack.push(s.substring(start, i));
        }
        while( !stack.isEmpty()) {
            builder.append(stack.pop()).append(" ");
        }
        System.out.println(builder.toString().trim());
    }
}

package com.example.algorithms.medium;

import java.util.Stack;

public class DecodeString {
    public static void main(String args[]) {
        String enc = "100[leetcode]";//""2[abc]3[cd]ef";//"3[a]2[bc]";
        System.out.println(decodeStringLeet(enc));
    }

    public static String decodeStringLeet(String s) {
        Stack<Integer> countStack = new Stack();
        Stack<String> stringStack = new Stack();
        int index = 0;
        String res = "";

        while(index < s.length()) {

            int count =0;
            if(Character.isDigit(s.charAt(index)) ){
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }

                countStack.push(count);
            }
            else if(s.charAt(index) == '[') {
                stringStack.push(res);
                res="";
                index++;
            }
            else if(s.charAt(index) == ']') {
                StringBuilder currentString = new StringBuilder( stringStack.pop());
                Integer repeatCount = countStack.pop();

                for(int i=0; i<repeatCount; i++ ) {
                    currentString.append(res);
                }
                res=currentString.toString();
                index++;
            }
            else {
                res+=s.charAt(index);
                index++;
            }

        }

        return res;

    }

    public static String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack stack = new Stack<String>();

        char strArray[] = s.toCharArray();

        int startIndex = 0;
        while(s.indexOf(']', startIndex) > 0) {
            int firstOccur=  s.indexOf(']', startIndex);
            int charIndex = firstOccur;
            StringBuilder currentStr = new StringBuilder();
            while (charIndex >= startIndex) {
                charIndex-=1;
                while (charIndex > 0 && !(strArray[charIndex] == '[')) {
                    currentStr.insert(0, strArray[charIndex]);
                    charIndex--;
                }
                charIndex -= 1;
                StringBuilder intString = new StringBuilder();
                while (charIndex >= 0 && strArray[charIndex] >= 48 && strArray[charIndex] <= 57) {
                    intString.insert(0,strArray[charIndex]);
                    charIndex--;
                }

                for (int i = 0; i < Integer.parseInt(intString.toString()); i++) {
                    result.append(currentStr.toString());
                }

            }
            startIndex = firstOccur+1;
        }

        if(startIndex != s.length()) {
            result.append(s.substring(startIndex));
        }

        return result.toString();

    }



}

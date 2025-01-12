package com.example.Top150.stack;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "1234567";
        Stack<Integer> stack = new Stack<>();
        int res =0;
        int sign =1;
        int number = 10;
        char operand ;
        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            } else if(c == '+') {
                sign = 1;
            }else if(c == '-') {
                sign = -1;
            }
            else if(c == '(') {
                stack.push(res);
                stack.push(sign);
                res =0;
                sign = 1;
            } else if(c == ')') {
                int lastSign = stack.pop();
                int lastRes = stack.pop();
                res = lastRes + lastSign * res ;
            }
            else {
                int startInd = i;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    i++;
                }
                int cur = Integer.parseInt(s.substring(startInd,i));
                i--;
                res+= sign * (cur);

            }

        }
        System.out.println (res);
    }
///Leet Code logic
    public int calculate(String s) {
        int resultSoFar = 0;
        int sign = 1;
        int operand = 0;
        Stack<Integer> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                operand = operand * 10 + (int)(c - '0');
            } else if(c == '+' || c == '-') {
                resultSoFar += operand * sign;
                sign = c == '+'? 1: -1;
                operand = 0;
            } else if(c == '(') {
                stack.push(resultSoFar);
                stack.push(sign);
                sign = 1;
                resultSoFar = 0;
                operand = 0;
            } else if(c == ')'){
                resultSoFar += operand * sign;

                int prevSign = stack.pop();
                int prevSum = stack.pop();
                resultSoFar = prevSum + (prevSign * resultSoFar);
                operand = 0;
                sign = 1;
            }
        }

        return resultSoFar + (operand * sign);
    }
}

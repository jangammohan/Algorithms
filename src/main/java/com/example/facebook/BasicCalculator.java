package com.example.facebook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        String s = "3+2*2";
        Deque<Integer> stack = new ArrayDeque<>();

        char sign = '+';
        int res = 0, i=0;
        int num =0;
        while(i<s.length()) {
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i)-'0';
            }

            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1) {
                if(sign == '+') {

                        stack.push(num);

                    }
            else if(sign == '-') {

                stack.push(-num);

            }  else if(sign == '*') {


                        stack.push(stack.pop() * num);

                    }
                    else if (sign == '/'){
                        stack.push(stack.pop() / num);

                    }

                sign = s.charAt(i);
                num =0;

            }
            i++;
        }

        while(!stack.isEmpty()) {
            res+=stack.pop();
        }
        System.out.println(res);
    }
}

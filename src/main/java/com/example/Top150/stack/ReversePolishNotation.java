package com.example.Top150.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        //String[] operators = {"+","-","*","/"};



        Stack<String> stack = new Stack<>();

        for(String st : tokens) {

                int fir =0;
                int sec =0;
                switch(st) {
                    case "+":
                        fir = Integer.parseInt(stack.pop());
                        sec = Integer.parseInt( stack.pop());

                        stack.push(Integer.toString(fir + sec));
                        break;
                    case "-":
                        fir = Integer.parseInt(stack.pop());
                        sec = Integer.parseInt( stack.pop());

                        stack.push(Integer.toString(sec - fir));
                        break;
                    case "*":
                        fir = Integer.parseInt(stack.pop());
                        sec = Integer.parseInt( stack.pop());
                        stack.push(Integer.toString(fir * sec));
                        break;
                    case "/":
                        fir = Integer.parseInt(stack.pop());
                        sec = Integer.parseInt( stack.pop());
                        stack.push(Integer.toString(sec / fir));
                        break;
                    default:
                        stack.push(st);

                }

            }


        System.out.println(stack.pop());
    }
}

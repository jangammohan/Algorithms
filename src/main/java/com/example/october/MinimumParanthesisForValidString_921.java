package com.example.october;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MinimumParanthesisForValidString_921 {

    public static void main(String[] args) {
        MinimumParanthesisForValidString_921 sol = new MinimumParanthesisForValidString_921();
        System.out.println(sol.minAddToMakeValid("()))(("));
    }

    public int minAddToMakeValid(String s) {
        int result =0;
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {


            if(ch == ')') {
                if(stack.isEmpty()){
                    result++;
                }else {
                    stack.pop();
                }

            }else {
                stack.add(ch);
            }

        }

        if(!stack.isEmpty()) {
            result+= stack.size();
        }


        return result;
    }

    //Leet solution
    public int minAddToMakeValidLeet(String s) {

        int front =0;
        int back =0;

        for(char ch: s.toCharArray()) {
            if(ch=='(') {
                front++;
            }else {
                if(front > 0) {
                    front--;
                }else {
                    back++;
                }
            }
        }
        return front+back;
    }
}

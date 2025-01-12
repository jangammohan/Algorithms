package com.example.amazon.easy;



import java.util.Stack;

public class StringValidParanthes {
    public static void main(String[] args) {
        String s = "([)]"; //"(]"; // "()[]{}";


        if(s.isEmpty()) {
            System.out.println("false");
        }
       Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '['  ) {
                stack.push(c);
            } else  {
                if(stack.isEmpty() ) {
                    return ;
                }
                if( c == ')' && stack.peek().equals('(') || c == '}' && stack.peek().equals('{') || c == ']' && stack.peek().equals('[') ) {
                    stack.pop();
                } else {
                    System.out.println("false");
                    return;
                }


            }
        }


        System.out.print(stack.isEmpty());
    }


}

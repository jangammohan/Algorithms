package com.example.algorithms.easy.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveParantheses {

    public static void main(String[] args) {
        String s = "))((";
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack();
        Set<Integer> hashSet = new HashSet<>();

        for(int i=0; i< s.length(); i++) {

            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else if(s.charAt(i) == ')') {
                if (stack.empty() ) {
                    hashSet.add(i);
                } else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()) {
         hashSet.add(stack.pop());
        }
        int j=0;

        while (j<s.length()) {
            if(!hashSet.contains(j)) {
                sb.append(s.charAt(j));
            }
            j++;
        }

        System.out.println(sb.toString());
    }
}

package com.example.september.array;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LongestValidParanthesis {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    result = Math.max(result, i-stack.peek());
                }
            }
        }
        return result ;
    }

    //Using for loop

    public int longestValidParanthesisUisngIterative(String s) {
        int result =0;
        int left = 0;
        int right =0;
        for(int i =0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            }else {
                right++;
            }
            if(left == right) {
                result = Math.max(result, 2* right);
            }

            if(right > left) {
                left = right = 0;
            }
        }

        left = right = 0;
        // Right to left scan
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return result ;
    }
}

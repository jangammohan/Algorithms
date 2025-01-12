package com.example.october;

import java.util.Stack;

public class MaximumWidthRamp_962 {

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
       // stack.add(0);
        for(int i =0; i< nums.length; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.add(i);
            }
        }
        int result =0;
        for(int i = nums.length-1; i>0 ; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                result = Integer.max(result, i- stack.pop() );
            }
        }

        return result;
    }
}

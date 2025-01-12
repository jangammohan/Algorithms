package com.example.september.array;

import java.util.Stack;

public class TrapRainWater_42 {

    public static void main(String[] args) {
        TrapRainWater_42 trap = new TrapRainWater_42();

        System.out.println(trap.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    //Stack code from chatGPT

    public int trapWithStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            // As long as there's a potential to trap water
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // Height of the valley

                if (stack.isEmpty()) {
                    break; // No left boundary to form a container
                }

                int distance = i - stack.peek() - 1; // Width of the trapped water
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top]; // Height of trapped water
                result += distance * boundedHeight;
            }

            stack.push(i); // Push current index to stack
        }

        return result;
    }

    public int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        int start = -1;
        int result = 0;
        int soFar = 0;
        for(int i =0; i<height.length; i++ ) {

            if(start < 0 && height[i] == 0) {
                continue;
            }

           // start = Math.max(start, height[i]);

            if(height[i] < start) {

                if(!stack.empty() && height[i] > stack.peek() ) {
                    int top = stack.pop();

                    soFar+= Math.min(height[i], stack.peek()) - top;
                }
                stack.push(height[i]);

            } else {
                while(!stack.isEmpty()) {
                    result+= start-stack.pop();
                }
                start = height[i];
                soFar = 0;
            }


        }
        if(!stack.empty()) {
            result+=soFar;
        }
        return result;
    }


    //LeetCode COrrect Solution


    public int trapWith2Array(int[] arr) {
        int result = 0;
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = arr[0];
        right[n-1] = arr[n-1];
        for(int i =1;i<left.length; i++){
            left[i] = Math.max(left[i-1], arr[i]);

        }

        for(int i =n-2; i>0; i--){
            left[i] = Math.max(right[i+1], arr[i]);

        }

        for(int i =0;i<n ; i++){
            result+= Math.min(left[i], right[i]) - arr[i];
        }

        return result;
    }
}

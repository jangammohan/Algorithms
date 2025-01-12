package com.example.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildingWithOceanView {

    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxInd = heights.length-1;
        stack.push(maxInd);
        for(int i= maxInd-1; i>=0 ;i--) {
            if(heights[i] > heights[maxInd]) {
                stack.push(i);
                maxInd = i;
            }
        }
        int result[] = new int[stack.size()];
        int ind =0;
        while(!stack.empty()) {
            result[ind++] = stack.pop();
        }

        return result;
    }
}

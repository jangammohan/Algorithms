package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAreaRectangle {
    public static void main(String[] args) {
        int[][] points = {{1,1}, {1,3}, {3,1},{3,3}, {2,2}};
        System.out.println(minAreaRect(points));
    }

    public static int minAreaRect(int[][] points) {

        Map<Integer, List<Integer>> coordinates = new HashMap<>();

        for(int[] p : points) {
            coordinates.computeIfAbsent(p[0], key-> new ArrayList<>()).add(p[1]);
        }
        int result = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if(p1[0] == p2[0] || p2[1] == p1[1]) {
                    continue;
                }

                if(coordinates.get(p1[0]).contains(p2[1]) && coordinates.get(p2[0]).contains(p1[1])) {
                    result = Math.min( (Math.abs(p2[0]-p1[0]) * Math.abs(p2[1]-p1[1])), result);
                }
            }

        }

        return (result== Integer.MAX_VALUE) ? 0 : result;
    }
}

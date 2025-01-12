package com.example.september.array;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_70 {

    public static void main(String[] args) {
        ClimbingStairs_70 climb = new ClimbingStairs_70();
        System.out.println(climb.climbStairs(5));
    }

    public int climbStairs(int n) {

        Map<Integer, Integer> map = new HashMap<>();


        return climbStair(n, map);
    }

    public int climbStair(int n, Map<Integer, Integer> map) {

        if(n==0 ){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(map.containsKey(n)) {
            return map.get(n);
        }

        int sum = climbStair(n-1, map) + climbStair(n-2, map);
        map.put(n, sum);
        return sum;
    }
}

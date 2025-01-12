package com.example.november;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUniqueFlavors_2107 {
    public static void main(String[] args) {
        NumberOfUniqueFlavors_2107 unique = new NumberOfUniqueFlavors_2107();

        System.out.println(unique.shareCandiesLeet(new int[]{1,2,3,2,2,2}, 3));
    }
///Getting time out exception
    public int shareCandies(int[] candies, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int can : candies) {
            map.put(can, map.getOrDefault(can,0)+1);
        }

        if(k == 0){
            return map.size();
        }


        int len = candies.length;
        int res = 0;
        for (int i =0; i <=len-k; i++) {
            int end = i+k-1;
            int start = i;
            int currentFlavors =0;
            Map<Integer, Integer> temp = new HashMap<>();
            while(start<=end) {
                if( temp.getOrDefault(candies[start],0)+1 ==
                        map.get(candies[start]) ) {


                    currentFlavors++;
                }
                else{
                    temp.put(candies[start],temp.getOrDefault(candies[start],0)+1);
                }
                start++;
            }

            res = Math.max(res, map.size()-currentFlavors);

        }

        return res;

    }

    //Leet solution -- ass & remove from map

    public int shareCandiesLeet(int[] candies, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int candy: candies){
            map.put(candy, map.getOrDefault(candy, 0)+1);
        }

        for(int i=0; i<candies.length;i++) {
            int candy = candies[i];
            map.put(candy, map.get(candy)-1);
            if(map.get(candy) == 0) {
                map.remove(candy);
            }

            if(i>=k){
                map.put(candies[i-k], map.getOrDefault(candies[i-k],0)+1);
            }
            if(i>=k-1){
                res = Math.max(res, map.size());
            }
        }
        return res;
    }
}

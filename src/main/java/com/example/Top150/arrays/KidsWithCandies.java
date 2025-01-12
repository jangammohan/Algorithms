package com.example.Top150.arrays;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxVal = Integer.MIN_VALUE;
        for(int a : candies) {
            if( maxVal<a){
                maxVal =a;
            }

        }

        for(int i=0;i<candies.length;i++) {
            result.add(i,candies[i]+extraCandies >= maxVal);
        }

        return result;
    }
}

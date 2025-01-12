package com.example.october;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ArrayPairsDivisibleByK_1497 {
    public static void main(String[] args) {
        ArrayPairsDivisibleByK_1497 pair = new ArrayPairsDivisibleByK_1497();
        pair.canArrange(new int[]{1,2,3,4,5,10,6,7,8,9}, 5);
    }

    public boolean canArrange(int[] arr, int k) {



        int mid = arr.length/2;

        Set<Integer> set = new HashSet<>();

        for(int i = mid ; i< arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i =0; i<mid;i++) {


            for(int val : set) {
                if((arr[i]+val) % k == 0) {
                    set.remove(val);
                    break;
                }
            }

        }
        return set.isEmpty();

    }
}

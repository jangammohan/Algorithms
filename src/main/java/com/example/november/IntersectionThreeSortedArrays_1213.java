package com.example.november;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionThreeSortedArrays_1213 {

    //More memory solution
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        // you can also use int[] cache = new int[2000], with int arrayit is faster than hashmap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int len = arr1.length;
        for(int i =0 ; i< len ; i++) {

            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        len = arr2.length;
        for(int i =0 ; i< len ; i++) {
            map.put(arr1[i],map.getOrDefault(arr2[i],0)+1);
        }
        len = arr3.length;
        for(int i =0 ; i< len ; i++) {

                if (map.getOrDefault(arr3[i],0) == 2) {
                    result.add(arr3[i]);
                }

        }
        return result;
    }


    //leet solution with no hashmap

    public List<Integer> arraysIntersectionLeet(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        //int first = 0;
        int first=0, second=0, third = 0;

        while(first < arr1.length && second < arr2.length && third < arr3.length) {
            if(arr1[first] == arr2[second] && arr1[first] == arr3[third]) {
                res.add(arr3[third]);
                first++;
                second++;
                third++;
            } else if(arr1[first] < arr2[second]) {
                first++;
            } else if(arr2[second] < arr3[third]) {
                second++;
            } else{
                third++;
            }
        }

        return res;
    }
}

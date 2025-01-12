package com.example.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RankTransform {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map =  new HashMap<>();

        int sortArray[] = arr.clone();
        Arrays.sort(sortArray);
        int rank =1;
        for(int i =0; i< sortArray.length; i++) {
            if(!map.containsKey(sortArray[i])) {
                continue;
            }
            map.put(sortArray[i], rank++);
        }


        int res[] = new int[arr.length];


        for(int i=0; i<arr.length;i++) {
            res[i] = map.get(arr[i]);
        }

    return res;
    }
}

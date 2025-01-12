package com.example.Top150.twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int numbers[] = {2,3,4};
        int target = 6;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< numbers.length;i++) {
            if(map.get(target-numbers[i]) == null) {
                map.put(numbers[i], i+1);
            }else {
                System.out.println(map.get(target-numbers[i]));
                System.out.println(i+1);
                System.out.println(new int[]{map.get(target-numbers[i]), i+1});
            }
        }
    }
}

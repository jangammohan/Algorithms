package com.example.amazon.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayZero {

    public static void main(String[] args) {
        int nums[] = {1, 5, 0, 3, 5};

        Set<Integer> set = new HashSet<>();
        for (int a: nums)
            if (a > 0)
                set.add(a);
       // return set.size();



        System.out.print("Number of iterations : "+set.size());


    }
}

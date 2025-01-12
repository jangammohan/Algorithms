package com.example.september.array;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber large = new LargestNumber();
        System.out.println(large.largestNumber(new int[]{10,2}));
    }

    public String largestNumber(int[] nums) {



        String str[] = new String[nums.length];

        for(int i =0; i< nums.length; i++) {

           str[i] = Integer.toString(nums[i]);

        }

        Arrays.sort(str, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        if(str[0].charAt(0) == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<str.length; i--) {
            sb.append(str[i]);
        }

    return sb.toString();
    }
}

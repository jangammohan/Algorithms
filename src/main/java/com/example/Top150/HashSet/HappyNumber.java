package com.example.Top150.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2;

        Set<Integer> set = new HashSet<>();

        while(n>0) {

            int sum =0;
            int temp = n;

            while(temp > 0) {
                int digit = temp%10;
                sum+=digit*digit;
                temp = temp/10;
            }
            if(sum == 1) {
                System.out.println(true);
                return;
            }
            if(set.contains(sum)) {
                break;
            }
            set.add(sum);
            n =sum;
        }

        System.out.println(false);
    }
}

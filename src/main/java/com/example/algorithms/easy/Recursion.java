package com.example.algorithms.easy;

public class Recursion {
    public static void main(String args[]) {
        System.out.println(fibonacci(4));
    }

    static int fibonacci(int n) {

        if(n==1 ) {
            return 1;
        }
        if(n==0 )
            return 0;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

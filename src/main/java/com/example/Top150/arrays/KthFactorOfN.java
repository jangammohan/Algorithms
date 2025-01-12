package com.example.Top150.arrays;

import java.util.HashMap;
import java.util.Map;

public class KthFactorOfN {

    public static void main(String[] args) {
        int n = 24; int k=6;

        for(int i=1 ; i<Math.sqrt(n); i++) {
            if(n%i == 0 && --k == 0) {
                System.out.println( i);
                return;
            }
        }
    int p = (int)Math.sqrt(n);
        for(int i = (int)Math.sqrt(n); i>=1; --i) {
            if(n % (n/i) == 0 && --k == 0) {
                System.out.println( n/i);
                return;
            }
        }

        System.out.println(-1);
    }
//-- MyCode
    public int kthFactor(int n, int k) {
        int mid = n/2;
        int result[] = new int[mid+1];

        int index = 1;
        result[0] = 1;
        for(int i = 2; i<=mid; i++) {
            if(n%i== 0) {
                result[index++] =  i;
            }
            int sqVal = i*2;
            if(n % sqVal == 0 && sqVal < n) {
                result[index+1] = sqVal;
            }

        }

        if(index < mid+1)
            result[index++] = n;

        return ((k<= index) ? result[k-1] : -1);
    }
}

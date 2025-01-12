package com.example.facebook;

import java.util.Random;

public class RandomPickWithWeight {
    int[] wSum;

    RandomPickWithWeight(int[] w) {
        wSum = new int[w.length];
        for(int i=0;i<w.length;i++){
            wSum[i] = (i==0)? w[i] : wSum[i-1]+w[i];
        }

    }

    public int pickIndex() {
        Random random = new Random();

        int randNum = (int) (Math.random() * wSum[wSum.length-1]);

        int left = 0;
        int right = wSum.length-1;
        int res =-1;
        while(left <= right) {
            int mid = left + (right-left)/2;

            if(randNum <  wSum[mid]  ) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] w = {1,3};
        RandomPickWithWeight random = new RandomPickWithWeight(w);
        System.out.println((int) (Math.random() * 14));
        System.out.println((int) (Math.random() * 14));
        System.out.println((int) (Math.random() * 14));
        System.out.println((int) (Math.random() * 14));
        System.out.println((int) (Math.random() * 14));

    }
}

package com.example.Top150.arrays;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        int []citations= {3,0,6,1,5};
        //Arrays.sort(citations);

        System.out.print(hIndex(citations));

        for(int i = citations.length; i > 0 ; i--) {
            int citSum =0;
            for(int j =0; j < citations.length;j++  ){
                if(citations[j] >= i) {
                    citSum++;
                }
            }

            if(citSum >=i){
                System.out.print(i);
                break;
            }

        }
    }

    public static int hIndex(int[] citations) {

        int temp[] = new int[citations.length+1];
        for(int i =0; i < citations.length; i++) {
            if(citations[i] >= citations.length) {
                temp[citations.length]++;
            }else {
                temp[citations[i]]++;
            }
        }
        int count =0;
        for(int i = citations.length; i>=0 ; i--) {
            count+= temp[i];
            if(count >= i ){
                return i;
            }
        }

        return 0;
    }
}

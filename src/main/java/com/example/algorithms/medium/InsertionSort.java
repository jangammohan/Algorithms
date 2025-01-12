package com.example.algorithms.medium;

public class InsertionSort {

    public static void main(String args[]) {
        int a[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};


        for(int i =0 ; i< a.length; i++) {
            int j= i;
            while( j > 0  ) {
                if(a[j-1] > a[j] ) {
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp ;

                }
                j--;

            }
        }

        for(int i =0; i< a.length; i++) {
            System.out.print(a[i]+"\t" );
        }
    }

}

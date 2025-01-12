package com.example.algorithms.medium;

import java.util.Arrays;

public class FindKLongestFromArray {


    public static void main(String args[]) {
        int a[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45};
        //partition(a, 0, a.length-1);
        int k =9;
        printKLargestNumbers(a, 0, a.length-1, k);
        for(int i =a.length-k ; i< a.length; i++) {
            System.out.print(a[i] +"\t");
        }
    }


    public static void printKLargestNumbers(int a[], int start, int end, int k) {

        // in array

        if (start < end) {

            int pivotal = a[end];
            int low = start;
            int temp;
            for (int i = start; i < end ; i++) {

                if (a[i] < pivotal) {
                    temp = a[i];
                    a[i] = a[low];
                    a[low] = temp;
                    low++;
                }

            }

            a[end] = a[low];
            a[low] = pivotal;


            if (end - low  < k-1 ) {
                printKLargestNumbers(a, start, low - 1, k);
            } else {
                printKLargestNumbers(a, low + 1, end, k );
            }
        }


    }


    public static void partition( int a[], int start, int end) {

        if(!(start<end)) {
            return;
        }

        int pivot = end;
        int n = start;
        int temp;
        for(int i =start ; i< end; i++) {
            if(a[i] <  a[pivot]) {
                 temp = a[i];
                a[i] = a[n];
                a[n] = temp;
                n++;
            }
        }
            temp = a[n];
            a[n] = a[pivot];
            a[pivot] = temp;

        partition(a, start, n-1);
        partition(a, n+1, end);

    }
}

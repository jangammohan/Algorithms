package com.example.algorithms.medium;

public class HeapSort {

    public static void main(String args[]) {

        int a[] = { 1,2,3,4,5,6,7 };

        sort(a);

        for(int i =0 ; i< a.length; i++) {
            System.out.print(a[i] +"\t");
        }
    }

    public static void heapify(int a[], int length, int i ) {

        int left = 2*i +1;
        int right = 2*i + 2;

        int largest = i;

        if(left < length && a[left] > a[largest]) {
            largest = left;
        }

        if(right < length && a[right] > a[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;

            heapify(a, length, largest);
        }


    }

    public static void sort(int a[]) {

        for(int i = a.length/2 -1; i>=0; i--) {
            heapify(a, a.length, i);
        }


        for(int j = a.length -1;j>0;j-- ) {

            int temp = a[j];
            a[j] = a[0];
            a[0] = temp;
            heapify(a, j, 0);
        }


    }
}

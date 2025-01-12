package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

 class Array {

    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String ars[]) {
        int[] arr = {1,2,3,4,5};

        permutation(arr, 0, arr.length-1);

        //permutationN(arr, 0);

       //heapAlgorithm(arr, arr.length);

    }

    private static void permutation(int[] arr, int start, int end) {

        if(start == end) {
            System.out.println(Arrays.toString(arr));
            result.add(Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new)));
           // result.add(Arrays.asList(arr));
        } else {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                permutation(arr, start+1, end);
                swap(arr, start, i);
            }
        }
    }

    private static void swap(int arr[], int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static void permutationN(int[] arr, int k) {
        if (k == arr.length - 1) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = k; i < arr.length; i++) {
                swap(arr, k, i);
                permutationN(arr, k + 1);
                swap(arr, k, i);
            }
        }
    }

    private static void heapAlgorithm(int[] arr, int n) {

        if(n == 1 ){
            System.out.println(Arrays.toString(arr));
            return;
        }

        for( int i =0; i< n; i++) {
            heapAlgorithm(arr, n-1);
            if(i%2 == 0) {
                swap(arr, i, n-1);
            }
            else  {
                swap(arr, 0, n-1);
            }
        }


    }
}

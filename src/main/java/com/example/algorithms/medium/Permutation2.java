package com.example.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation2 {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        permutation(arr, 0, arr.length-1);
        System.out.println(result.stream().toString());
    }

    private static void permutation(int[] arr, int start, int end) {

        if(start == end) {
            System.out.println(Arrays.toString(arr));
            result.add(Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new)));
            // result.add(Arrays.asList(arr));
        } else {
            for (int i = start; i <= end; i++) {
                if(i!=start && arr[i] == arr[i-1]) {
                    continue;
                }
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


    ///Leet BackTrack code

    private void backTrack(int[] arr, List<Integer> current, Boolean[] bool, List<List<Integer>> result) {
        if(current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<arr.length;i++) {
            if(bool[i])
                continue;
            bool[i]= true;
            current.add(arr[i]);
            backTrack(arr, current, bool, result);
            current.remove(current.size()-1);
            bool[i] = false;
        }
    }
}

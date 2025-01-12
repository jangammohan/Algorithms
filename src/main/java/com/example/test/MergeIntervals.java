package com.example.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String args[]) {

        int intervals[][] = {{2,3},{4,5},{6,7},{8,9},{1,10}} ;//{{1,3},{8,10}, {15,18}, {2,6}};



        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]) );
        List<int[]> resultList = new ArrayList<>();

        resultList.add(intervals[0]);
        int currentIndex =0;
        for(int k =1; k< intervals.length; k++) {
            int[] temp = resultList.get(currentIndex);
            if(temp[0] <= intervals[k][0] && intervals[k][0] <= temp[1]) {

                if(temp[1] < intervals[k][1])
                    temp[1] = intervals[k][1];

            }else {
                resultList.add(intervals[k]);
                currentIndex++;
            }

        }



        for (int[] t: resultList) {
            System.out.print("[");
            for(int val: t ) {
                System.out.print(+val+"\t");
            }
            System.out.println("]");
        }

       resultList.toArray(new int[resultList.size()][]);


    }


    public <T> void  printArray(List<int[]> resultList ) {


        for (int[] t: resultList) {
           for(int val: t ) {
               System.out.print("["+t+",\t");
           }
            System.out.println("]");
        }
    }

    public void partition(int[][] array, int start, int end) {


        if(start<end) {

            int mid = (start+end-1) / 2;

            partition(array, start, mid);
            partition(array, mid+1, end );

            merge(array, start, end, mid);

        }

    }

    public void merge(int[][] array, int left, int right, int mid) {

        int lindex = mid - left +1;
        int rindex = right - mid;

        int leftArray[][] = new int[lindex][2];
        int rightArray[][] = new int[rindex][2];

        for(int i =0; i< lindex; i++) {
            leftArray[i] = array[left+i];

        }

        for(int m =0; m< rindex; m++) {
            rightArray[m] = array[mid+1+m];


        }

        int k =0; int l = 0;

        int p = left;
        for( ; k<lindex && l < rindex ;  ) {

            if( leftArray[k][0] <=  rightArray[l][0]  ) {
                array[p] = leftArray[k];
                k++;

            } else {
                array[p] = rightArray[l];

               l++;
            }
            p++;

        }

        while(k<lindex) {
            array[p] = leftArray[k++];
            p++;
        }

        while(l<rindex) {
            array[p] = rightArray[l++];
            p++;
        }



    }
}

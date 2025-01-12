package com.example.test;

public class TwoSortedArrMedian {

    public static void main(String arg[]) {

        int nums1[] = {1,3};
        int nums2[] = {2,4};

        int sortedArray[] = new int[nums1.length + nums2.length];

        int i = 0,j=0,k=0;
        for (  ; i < nums1.length  && j < nums2.length;  ) {

            if(nums1[i] < nums2[j]) {
                sortedArray[k++] = nums1[i];
                i++;
            }
            else if(nums1[i] == nums2[j]) {
                sortedArray[k++] = nums1[i];
                sortedArray[k++] = nums2[j];
                i++;
                j++;
            }else {
                sortedArray[k++] = nums2[j];
                j++;
            }
        }

        if(i < nums1.length) {
            for (;i < nums1.length;) {
                sortedArray[k++] = nums1[i++];
            }
        }

        if(i < nums2.length) {
            for (;i < nums2.length;) {
                sortedArray[k++] = nums2[i++];
            }
        }


        if (sortedArray.length % 2 == 0) {
            int middle = (sortedArray.length/2);
           System.out.println("Median - "+ ( (sortedArray[middle-1] + sortedArray[middle]) / 2 ));
        } else {
            int middle = (sortedArray.length + 1) / 2 ;
            System.out.println("Median - "+ sortedArray[middle-1] );
        }

    }
}

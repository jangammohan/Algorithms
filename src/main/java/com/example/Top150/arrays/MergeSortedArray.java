package com.example.Top150.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int nums1[]= {4,5,6,0,0,0};
        int m = 3;
        int n = 3;
        int nums2[] = {1,2,3};
        int i =0;
        int j= 0;

        if(n==0){
            System.out.println( nums1);
        }

        if(m ==0  && n!=0) {
            for(int k =0 ; k<n;k++) {
                nums1[k] = nums2[k];

            }
            System.out.println(nums1);
        }

        for(;  j<n ; j++) {
            while(i<m && nums1[i] <= nums2[j]) {
                i++;
            }

            if(i<m ) {
                int rest = m - i;
                int temp = m;
                while (rest > 0) {
                    nums1[temp] = nums1[temp - 1];
                    rest--;
                    temp--;
                }
                nums1[i] = nums2[j];
                m = m + 1;
            } else {
                break;
            }


        }

        while(j < n) {
            nums1[m++] = nums2[j];

            j++;
        }

       Arrays.stream(nums1).forEach(System.out::println);

        MergeSortedArray ma = new MergeSortedArray();
         int numsa[]= {4,5,6,0,0,0};
         m = 3;
         n = 3;
         int numsb[] = {1,2,3};
        ma.merge(numsa,3,numsb,3);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1; int j = n-1; int k = m+n-1;

        while(j>=0) {
            if(i>=0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        Arrays.stream(nums1).forEach(System.out::print);
    }
}

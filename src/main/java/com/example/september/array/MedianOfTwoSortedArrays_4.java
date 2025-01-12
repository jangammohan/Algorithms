package com.example.september.array;

public class MedianOfTwoSortedArrays_4 {

    public static void main(String[] args) {
        MedianOfTwoSortedArrays_4 med = new MedianOfTwoSortedArrays_4();
        System.out.println(med.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null && nums2 == null  ) {
            return 0.0;
        }

        if(nums1 == null ) {
            int ind = nums2.length/2;
            return (nums2.length % 2) == 0 ? (double)(nums2[ind] + nums2[ind -1])/2 : (double)nums2[ind];
        }


        if(nums2 == null ) {
            int ind = nums1.length/2;
            return (nums1.length % 2) == 0 ? (double)(nums1[ind] + nums1[ind -1])/2 : (double)nums1[ind];
        }

        int m= nums1.length;
        int n=  nums2.length;
        int merArr[] = new int[m+n];

        int ind1 =0;
        int ind2 = 0;
        int merInd =0;

        while (ind1 < m && ind2 < n) {

            if( nums1[ind1] <= nums2[ind2]) {
                merArr[merInd++] = nums1[ind1++];
            }

            else {
                merArr[merInd++] = nums2[ind2++];
            }
        }

        while(ind1 < m) {
            merArr[merInd++] = nums1[ind1++];
        }

        while(ind2 < n) {
            merArr[merInd++] = nums2[ind2++];
        }

        int medInd = (m + n) / 2;
        System.out.println((merArr[medInd] + merArr[medInd -1])/2);
        System.out.println(merArr[medInd]);
        System.out.println(merArr[medInd -1]);
        double res = ((m+n) % 2 ) ==0 ? (double)(merArr[medInd] + merArr[medInd -1])/2 : (double)merArr[medInd];
        return res;
    }

}

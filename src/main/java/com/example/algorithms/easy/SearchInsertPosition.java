package com.example.algorithms.easy;

public class SearchInsertPosition {

    public static void main(String args[]) {

        int nums[] = {1,3,5,6};
        int target = 7;
        int result =  searchInsert(nums, target);

        System.out.print(
                 result);


    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while(left < right) {

            int mid = (left+right) / 2 ;



            if(nums[mid] < target) {
                left = mid+1;
            }else {
                right = mid;
            }


        }
        return (nums[left] == target) ? left :
        (nums[left] < target) ? left+1 : left;


        }

}

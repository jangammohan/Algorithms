package com.example.Top150.arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int nums[]= {0,0,1,1,1,1,2,3,3};

            int index =1;
            int dup =0;

        for(int i =1; i<nums.length;i++) {

            if(nums[i-1] != nums[i] ) {
                nums[index++] = nums[i];
                dup=0;
            }
            else if(nums[i-1] == nums[i] && dup < 1 ) {
                nums[index++] = nums[i];
                dup++;
            } else{
               // nums[index] = nums[i+1];
            }
        }

        System.out.println(index);
    }
}

package com.example.Top150.arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int nums[]= {3,2,2,3};
        int val = 3;

        int removeElement = nums.length-1;
        for(int i =nums.length-1; i>=0; i--) {

            if(nums[i] == val) {
                int temp = nums[removeElement];
                nums[i] = temp;
                nums[removeElement] = 0;
                removeElement--;
            }
        }
        System.out.println(removeElement+1);
    }
}

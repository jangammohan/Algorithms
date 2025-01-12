package com.example.facebook;

public class SparseVector {

    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result =0;

                for(int i=0 ; i<vec.nums.length; i++ ) {
                   if(this.nums[i] !=0 && vec.nums[i] !=0) {
                       result+= this.nums[i] * vec.nums[i];
                   }
        }

        return result;
    }
}

package com.example.test;

public class RemoveDuplicates {

    public static void main(String args[]) {

    int[] nums = {0,0,1,1,1,2,2,3,3,3};

            if(nums.length == 0  )
                return ;

            int j = 0;
            for(int i =0; i< nums.length-1; i++){

                if(nums[i] != nums[i+1]){
                    nums[j] = nums[i];
                    j++;
                }
            }
            nums[j++] = nums[nums.length-1];


            for(int k=0;k< j;k++ ){
                System.out.print(k+"\t");
            }


    }
}

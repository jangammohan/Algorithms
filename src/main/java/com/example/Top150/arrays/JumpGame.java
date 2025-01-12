package com.example.Top150.arrays;

public class JumpGame {

    public static void main(String[] args) {
        int []nums= {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        int lastIndex = nums.length-1;
        int current =0;
        for(int i =0 ;i<nums.length; i++) {
            current+=nums[i];

            while(current <lastIndex ) {
                if(nums[current] == 0) {
                    //System.out.print("false");
                    break ;
                }
                current+= nums[current];

            }

            if(current >= lastIndex) {
                //System.out.print("true");
                //return ;
            }
            if(nums[i] == 0) {
                //System.out.print("false");
                break ;
            }

            current=i+1;

        }
        System.out.print(Jump(nums));
    }

    //Leet Code
    public static  boolean canJump(int[] nums) {

        int max =0;
        for(int i =0 ; i<nums.length;i++) {
            if(max < i) {
                return false;
            }
            max = Math.max(i+nums[i], max);
            if(max>=nums.length-1){
                break;
            }
        }

        return true;
    }

    public static  int Jump(int[] nums) {

        int start =0;
        int far = 0;
        int res =0;
        for(int i =0; i< nums.length-1;i++) {

            far = Math.max(i+nums[i], far);

            if(i==start) {
                res++;
                start = far;
            }
        }


        return res;
    }
}

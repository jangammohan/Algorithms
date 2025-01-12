package com.example.Top150.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class DistinctSubarrayWithLengthK {

    public static void main(String[] args) {
        int nums[] = {1,1,1,7,8,9};

            int k =3;
            int max =0;
            int result =0;

        HashSet<Integer> hashSet = new HashSet<>();
        int windowStart =0;
        for(int i=0;i<nums.length;i++) {

            while(hashSet.contains(nums[i]) || hashSet.size() == k) {
                result-=nums[windowStart];
                hashSet.remove(nums[windowStart++]);
            }

            result+= nums[i];
            hashSet.add(nums[i]);
            max = Math.max(result, max);
        }



        System.out.println(max);
    }

    public long maximumSubarraySum(int[] nums, int k, int i, int sum) {

        if(i == nums.length){
            return 0;
        }

        if(i>0 && nums[i-1] == nums[i]) {
            return 0;
        }
        int sub =0;
        for(int j =i; i<nums.length;j++){

            if(j>0 && nums[j-1] == nums[j]) {
               continue;
            }
            else if(sub <k) {
                sum = Math.max(sum, sum+nums[j]);
                sub++;
            }
            maximumSubarraySum(nums, k,j+1, sum);
        }
        return 0;
    }
}

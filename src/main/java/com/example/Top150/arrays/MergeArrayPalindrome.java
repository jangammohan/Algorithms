package com.example.Top150.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeArrayPalindrome {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int left =0;
        int right =nums.length-1;
        int result =0;
        while (left < right) {
            if(nums[left] == nums[right]) {
                left++;
                right--;
            } else if(nums[left] < nums[right]) {
                nums[left+1] = nums[left] + nums[left+1];
                left++;
                result++;
            } else {
                nums[right-1] = nums[right]+nums[right-1];
                result++;
                right--;
            }
        }
        List<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 7, 8, 4));
        List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());
      List<Integer> ls = (List<Integer>) Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());


        System.out.print(result);
    }
}

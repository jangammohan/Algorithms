package com.example.september.array;

public class TopKElmentsUsingHeap_239 {

    public int findKthLargest(int[] nums, int k) {

        for(int i =nums.length/2 -1; i>0; i--) {
            heapify(i, nums.length, nums);
        }

        for(int i = nums.length-1; i >= nums.length-1-k; i-- ) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(0, i, nums);
        }

        return nums[nums.length-k];

    }

    private void heapify(int ind, int lenght, int[] nums) {
        int left = 2* ind +1;
        int right = 2 * ind +2;

        int largest = ind;
        if(left < lenght && nums[left] > nums[largest]) {
            largest = left;
        }

        if(right < lenght && nums[right] > nums[largest] ) {
            largest = right;
        }

        if(largest != ind ) {
         int temp = nums[ind];
         nums[ind] = nums[largest];
         nums[largest] = temp;
         heapify(largest, lenght, nums);
        }
    }
}

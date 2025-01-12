package com.example.september.array;

import java.util.*;

public class MaxSlidingWindow_239 {
    public static void main(String[] args) {
        MaxSlidingWindow_239 window = new MaxSlidingWindow_239();
        int[] res = window.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

        Arrays.stream(res).forEach(value -> System.out.print(value));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k+1] ;


        Deque<Integer> queue = new ArrayDeque<>();

        for(int i =0 ; i < nums.length ; i++) {

            while(queue.size() > 0 && queue.peekFirst() <= i-k) {
                queue.pollFirst();
            }

            while(queue.size() > 0 && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.add(i);
            if(i >= k-1) {
                res[i-k+1] = nums[queue.peekFirst()];
            }

        }
        return res;



    }

    public void sort(int[] nums, int start, int end) {

        for(int i = end/2-1; i>0; i--) {
            heapify(i, end -start, nums);
        }

    }

    public void heapify(int i, int length, int[] nums) {
        int left = i + 1;
        int right = i+2;

        int largest = i;

        if(left < length && nums[left] > nums[largest]) {
            largest = left;
        }

        if( right < length && nums[right] > nums[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(largest, length, nums);
        }
    }
}

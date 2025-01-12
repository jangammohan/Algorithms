package com.example.Top150.twopointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};

        int start = 0;
        int end = height.length-1;

        int maxheight =0;
        int maxWater =0;

        while(start < end) {
            if(height[start] > maxheight && height[end] > maxheight) {
                maxheight = Math.min(height[start], height[end]);
                maxWater = Math.max(maxWater, (end-start)*maxheight);
            }

            if(height[start] == height[end]) {
                start++;
                end--;
            }
            else if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }

        System.out.println(maxWater);
    }
}

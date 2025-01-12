package com.example.amazon;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,9,2,5,4,9,3,7}; //{1,2,1};  // {1,8,6,2,5,4,8,3,7};

        System.out.println(findCOntainter(height));

    }


    private static int containter(int[] height) {

        int maxsoFar = 0;
        for(int i =0; i< height.length; i++) {
            int width = height.length-i-1;
            int maxHeight =  Math.min(height[i],height[width] );
            maxsoFar = Math.max(maxsoFar, width*maxHeight);
        }

        return maxsoFar;
    }

    public static int findCOntainter(int[] height) {

        int left =0, right = height.length -1;
        int maxArea =0;
        int maxHeight = 0;

        while(left < right ) {

            if(height[left] > maxHeight && height[right] > maxHeight) {
                maxHeight = Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, (right-left)*maxHeight);
            }

            if(height[left] == height[right]) {
                left++;
                right--;
            }
            else if(height[left] < height[right]) {
                left ++;
            }else {
                right --;
            }

        }
        return maxArea;

    }
}

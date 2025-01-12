package com.example.algorithms.medium;

public class CircleRectangleOverlap {
    public static void main(String[] args) {
        int radius = 1415;
        int xCenter =807;
        int yCenter =-784;
        int x1 = -733;
        int y1 = 623;
        int x2 = -533;
        int y2 = 1005;
        System.out.println(checkOverlap(radius,xCenter, yCenter, x1, y1,x2,y2));
    }

    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        int width = Math.min(radius+xCenter, x2)- Math.max(xCenter-radius, x1 )  ;
        if(width >= 0) {
           int length = Math.min(radius+yCenter, y2) - Math.max(yCenter-radius, y1 )  ;
            if(length>=0){
                return true;
            }
        }


        return false;
    }
}

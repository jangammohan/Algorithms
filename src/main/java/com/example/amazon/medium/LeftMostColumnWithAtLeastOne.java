package com.example.amazon.medium;


import java.util.List;

interface BinaryMatrix {
      public int get(int row, int col) ;
      public List<Integer> dimensions ();
  }

public class LeftMostColumnWithAtLeastOne {

    public static void main(String[] args) {

    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        List<Integer> meta = binaryMatrix.dimensions();


        for(int i =0 ; i< meta.get(1); i++) {
           //int prev = binaryMatrix.get(i,0);
            int current = Integer.MIN_VALUE;
            for(int j=0 ; j< meta.get(0); j++) {
                current = binaryMatrix.get(j,i);
                if(  current == 1  ) {
                    return i;
                }

            }
        }


        return -1;
    }

    public static int leftMostColumnWithOneBFS(BinaryMatrix binaryMatrix) {

        List<Integer> meta = binaryMatrix.dimensions();
        int rows = meta.get(0); int cols = meta.get(1);

        int left = 0, right = cols-1;

        int ans = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(existIncolum(binaryMatrix, rows, mid)) {

                ans = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }

        }



        return ans;
    }

    public  static boolean existIncolum(BinaryMatrix binaryMatrix, int rows, int col) {
        for (int r = 0; r< rows; r++ ) {
            if(binaryMatrix.get(r,col) ==1) {
                return true;
            }
        }
        return false;
    }

}

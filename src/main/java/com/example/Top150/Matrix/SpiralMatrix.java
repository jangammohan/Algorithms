package com.example.Top150.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3}, {4,5,6}, {7,8,9}};

        List<Integer> result = new ArrayList<>();

       int rowBegin = 0;
       int rowEnd = matrix.length-1;
       int colBegin = 0;
       int colEnd = matrix[0].length-1;

       while(  rowBegin<=rowEnd  && colBegin<=colEnd) {

           for(int i = colBegin; i<=colEnd; i++) {
               result.add(matrix[rowBegin][i]);
           }
           rowBegin++;
           for(int j=rowBegin;j<=rowEnd;j++ ){
               result.add(matrix[j][colEnd]);
           }

           colEnd--;

           if(rowBegin<=rowEnd) {
               for(int i=colEnd;i>=colBegin;i--){
                   result.add(matrix[rowEnd][i]);
               }
           }
           rowEnd--;

           if(colBegin<=colEnd){
               for(int j= rowEnd;j>=rowBegin;j--) {
                   result.add(matrix[j][colBegin]);
               }
           }
           colBegin++;

       }

       result.forEach(System.out::print);

    }
}

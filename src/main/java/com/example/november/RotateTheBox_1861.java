package com.example.november;

import java.util.Arrays;

public class RotateTheBox_1861 {

    public static void main(String[] args) {
        RotateTheBox_1861 rotate = new RotateTheBox_1861();

        char[][] res = rotate.rotateTheBox(new char[][]{{'#','.','*','.'},{'#','#','*','.'}});
        System.out.println(Arrays.deepToString(res));
    }
    public char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];

        for (int i = 0; i < box.length; i++) {
            int temp = box[i].length-1;
            for (int j = temp; j >= 0; j--) {

                if (box[i][j] == '*' ) {
                    temp = j-1;
                    //box[i][j]= '#';
                    //box[i][j-1]='.';

                }  else if (box[i][j] == '#' ) {
                    box[i][j] = '.';
                    box[i][temp] = '#';

                    --temp;
                }

            }
        }

        int row = box.length;
        for (int i = 0; i < row ; i++) {

            for (int j = box[0].length-1; j >=0 ; j--) {
                res[j][row-i-1] = box[i][j];
            }


        }
        return res;
    }
}
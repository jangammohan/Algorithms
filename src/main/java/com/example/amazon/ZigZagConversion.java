package com.example.amazon;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;

        StringBuilder[] ls = new StringBuilder[numRows];

        for(int i =0; i<numRows;i++) {
            ls[i] = new StringBuilder();
        }

        int fwd =-1;
        boolean reverse = false;
        for( char c : s.toCharArray()) {
            if(!reverse ) {
                ls[++fwd].append(c);

                if(fwd == numRows-1) {
                    reverse =true;
                }
            } else {
                fwd--;
                ls[fwd].append(c);

                if(fwd == 0) {
                    reverse = false;
                }
            }

        }

        StringBuilder sb = new StringBuilder();

        for(StringBuilder l : ls) {
            sb.append(l.toString());
        }

        System.out.print(sb.toString());
    }
}

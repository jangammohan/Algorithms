package com.example.september.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LexicographicalNumbers_386 {

    public static void main(String[] args) {
        LexicographicalNumbers_386 lex = new LexicographicalNumbers_386();
        System.out.println(lex.lexicalOrderOthers(13));
    }

    public List<Integer> lexicalOrder(int n) {

        List<Integer> result = new ArrayList<>();

        for(int i =1 ; i<=n;i++) {
            result.add(i);

        }

        Collections.sort(result, (a, b)->
        a.toString().compareTo(b.toString())

        );

        return result;

    }


    //Leet Code solution others

    public List<Integer> lexicalOrderOthers(int n) {
        List<Integer> result = new ArrayList<>();
        int currentNum = 1;
        for(int i =0; i < n; i++) {
            result.add(currentNum);

            if(currentNum *10 <= n) {
                currentNum *= 10;
            } else {

                while(currentNum % 10 == 9 || currentNum >= n) {
                    currentNum /= 10;
                }
                currentNum +=1;
            }
        }

        return result;
    }
}

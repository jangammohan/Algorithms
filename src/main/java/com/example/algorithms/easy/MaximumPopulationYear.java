package com.example.algorithms.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumPopulationYear {

    public static void main(String[] args) {
        int[][] logs = {{1982,1998}, {2013,2042}, {2010,2035}, {2022,2050}, {2047,2048}}; //{{1950,1961}, {1960,1971}, {1970,1981}};// {{1993,1999}, {2000,2010}};

       System.out.println( maximumPopulation(logs));
    }
    public static int maximumPopulation(int[][] logs) {


        if(logs.length == 1) {
            return logs[0][0];
        }

       int year[] = new int[101];

        for(int[] log : logs  ) {
            year[log[0]-1950]++;
            year[log[1]-1950]--;
        }

        int maxNum = year[0];
        int maxYear = 1950;

        for(int i =1; i< year.length;i++) {
            year[i]+=year[i-1];
            if(year[i] > maxNum) {
                maxNum = year[i];
                maxYear =i+1950;
            }
        }

        return maxYear;
    }
}

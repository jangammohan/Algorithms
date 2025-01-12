package com.example.algorithms.medium;

import java.util.*;

public class CinemaSeatAllocation {

    public static void main(String[] args) {
        int n = 3;
        int reservedSeats[][] = {{1,2},{1,3}, {1,8}, {2,6}, {3,1}, {3,10}};

        System.out.println(maxNumberOfFamilies(3, reservedSeats));

    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> rowReservedSeats = new HashMap<>();

        int result =0;

        for(int[] reserved: reservedSeats) {
//            if(rowReservedSeats.containsKey(reserved[0])) {
//                rowReservedSeats.get(reserved[0]).add(reserved[1]);
//            }
            rowReservedSeats.computeIfAbsent(reserved[0], key -> new HashSet<>()).add(reserved[1]) ;
        }

        result = (n - rowReservedSeats.size())*2;

        for ( Set rowSeats : rowReservedSeats.values() ) {
                boolean left = false, right =false;
            if(!rowSeats.contains(2) && !rowSeats.contains(3) && !rowSeats.contains(4) && !rowSeats.contains(5)) {
                result++;
                left = true;
            }

            if(!rowSeats.contains(6) && !rowSeats.contains(7) && !rowSeats.contains(8) && !rowSeats.contains(9)) {
                result++;
                right = true;
            }

            if(!left && !right && !rowSeats.contains(4) && !rowSeats.contains(5) && !rowSeats.contains(6) && !rowSeats.contains(7)) {
                result++;

            }


        }

        return result;
    }
}

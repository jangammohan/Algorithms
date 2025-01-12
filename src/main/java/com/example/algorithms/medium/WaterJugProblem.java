package com.example.algorithms.medium;

public class WaterJugProblem {
    public static void main(String[] args) {
        int jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3;
        int sum = jug2Capacity + jug1Capacity;

        if(sum == targetCapacity || sum < targetCapacity) {
            //return true;
            System.out.println(true);
        }else if(sum > targetCapacity) {

            int max = Math.max(jug2Capacity,jug1Capacity);
            int min = Math.min(jug2Capacity, jug1Capacity);

            int sofar = targetCapacity - min;

                System.out.println((min+sofar == targetCapacity) || (max-sofar == targetCapacity) );


        }
        else {
            System.out.println(false);
        }
    }
}

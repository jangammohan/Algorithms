package com.example.algorithms.medium;

public class DenoteMaximumBombsPractice {
    int bombs[][] = {{1,2,3}, {2,3,1}, {3,4,2}, {4,5,3}, {5,6,4}};//  {{2,1,3}, {6,1,4}}; // {{1,1,5}, {10,10,5}};// {{1,2,3}, {2,3,1}, {3,4,2}, {4,5,3}, {5,6,4}};
    public static void main(String args[]) {

        DenoteMaximumBombsPractice detnoteNombs = new
                DenoteMaximumBombsPractice();

        System.out.println(detnoteNombs.maximumDetonation(detnoteNombs.bombs));


    }

    public int maximumDetonation(int[][] bombs) {

        if(bombs.length == 1) {
            return 1;
        }

       // Arrays.sort(bombs, (arry1, arry2) -> Integer.compare(arry1[0], arry2[0]));

        boolean[] visited = new boolean[bombs.length];

        int max =1;
        for(int k =0 ; k< bombs.length ; k++ ) {
            visited[k] = true;
//            int xLeftRange =bombs[k][0] - bombs[k][2];
//            int xlastRange =bombs[k][0] + bombs[k][2];
//
//
//            int yLeftRange =bombs[k][1] - bombs[k][2];
//            int ylastRange =bombs[k][1] + bombs[k][2];

            int j =0 ;
            int currentMax = 1;
            while(j< bombs.length && visited[j] == false) {


                long distance = ( (long) (bombs[j][0] - bombs[k][0]) * (long) (bombs[j][0] - bombs[k][0])) +
                        ((long)(bombs[j][1] - bombs[k][1]) * (long)(bombs[j][1] - bombs[k][1]));
                long range = ((long)bombs[k][2]*(long)bombs[k][2])  ;

//                if( (bombs[j][0] >= xLeftRange && bombs[j][0] <= xlastRange) ||
//                        (bombs[j][1] >= yLeftRange && bombs[j][1] <= ylastRange)  ) {
//                    currentMax++;
//                }

                if( distance <= range ) {
                    currentMax++;
                }

                j++;
            }
            visited[k] = false;

            max = Math.max(max, currentMax);

        }

        return max;
    }

}

package com.example.algorithms.medium;

import java.util.LinkedList;
import java.util.Queue;

public class DetonatedWithQueue {
    int bombs[][] = {{1,2,3}, {2,3,1}, {3,4,2}, {4,5,3}, {5,6,4}};

    public static void main(String args[]) {
        DetonatedWithQueue detnoteNombs = new
                DetonatedWithQueue();

        System.out.println(detnoteNombs.maximumDetonation(detnoteNombs.bombs));
    }

    public int maximumDetonation(int[][] bombs) {

        boolean[] visited ;
        Queue queue = new LinkedList();


        queue.add(bombs[0]);
        int i =0;
        int result = 1;

        while(!queue.isEmpty() ) {
            visited = new boolean[bombs.length];
            int[] temp = (int[])queue.poll();

            visited[i] = true;
                    for(int j =0; j< bombs.length; j++ ) {

                        if(ifWithinRadius(bombs[i], bombs[j]) && (visited[j] == false)) {
                            queue.add(bombs[j]);
                            result+=1;
                        }

                    }
            i++;

           // result = Math.max(result, currentDetonated);
        }

        return result;
    }

    boolean ifWithinRadius(int[] currBomb, int[] bomb) {
        //we are using eucledian distsance formula(d =√[(x2 – x1)2 + (y2 – y1)2]) to check the distance between two centers of the circles.
        //if ([(x2 – x1)2 + (y2 – y1)2])<=(r)2, the 'bomb' is within the range of 'currBomb'.
        if ((long) (currBomb[0] - bomb[0]) * (long) (currBomb[0] - bomb[0]) + (long) (currBomb[1] - bomb[1]) * (long) (currBomb[1] - bomb[1]) <= (long) ((long) currBomb[2] * (long) currBomb[2])) {
            return true;
        }
        return false;
    }


}

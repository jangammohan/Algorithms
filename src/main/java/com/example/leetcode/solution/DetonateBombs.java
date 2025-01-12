package com.example.leetcode.solution;

public class DetonateBombs {

    int bombs[][] = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};//  {{2,1,3}, {6,1,4}}; // {{1,1,5}, {10,10,5}};// {{1,2,3}, {2,3,1}, {3,4,2}, {4,5,3}, {5,6,4}};

    public static void main(String args[]) {

        DetonateBombs detnoteNombs = new
                DetonateBombs();

        System.out.println(detnoteNombs.maximumDetonation(detnoteNombs.bombs));

    }

    public int maximumDetonation(int[][] bombs) {
        int ans = 0;

        for (int i = 0; i < bombs.length; i++) {
            //Do DFS starting with i-th bomb. Store the number of bombs detonated in variable num
            int num = DFS(i, bombs, new boolean[bombs.length]);
            //store the max value in 'ans'.
            ans = Math.max(ans, num);
        }

        return ans;
    }

    int DFS(int i, int[][] bombs, boolean[] isDetonated) {

        //mark the present bomb as detonated so as to avoid self loop(stack overflow).
        isDetonated[i] = true;

        int retVal = 0;
        for (int j = 0; j < bombs.length; j++) {
            int[] bomb = bombs[j];
            //for j-th bomb, check if it is in the range of i-th bomb by calling ifWithinRadius().
            //And also ensure that j-th bomb is not detonated.
            //If these conditions are satisfied, make a recursive call with j-th bomb
            //Add number of bombs detonated by making call to all such j-th bombs and store it in the variable 'retVal'.
            if (ifWithinRadius(bombs[i], bomb) && isDetonated[j] == false) {
                retVal += DFS(j, bombs, isDetonated);
            }
        }

        //We are returning total number of bombs detonated + i-th bomb(count = 1)
        return retVal + 1;
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

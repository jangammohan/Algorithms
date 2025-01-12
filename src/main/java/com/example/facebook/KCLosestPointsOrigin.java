package com.example.facebook;

import java.util.*;

public class KCLosestPointsOrigin {
    public static void main(String[] args) {
        int points[][] = {{3,3},{5,-1}, {-2,4}};
        KClosest(points, 1);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        pq.poll();
    }

    public static int[][] KClosest(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> ( (int)Math.sqrt(p1[0] * p1[0] + p1[1] * p1[1]) -
                (int ) Math.sqrt(p2[0] * p2[0] + p2[1] * p2[1])));
        return Arrays.copyOfRange(points, 0, k);


    }
}

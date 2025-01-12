package com.example.algorithms.medium;

import java.util.*;

public class MostProfitablePath {


    public static void main(String[] args) {
        int edges[][] = {{0,1}, {1,2}, {1,3}, {3,4}};
        int bob =3;
        int amount[] = {-2,4,2,-4,6};

        System.out.println(mostProfitablePath(edges,bob,amount));
    }

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {

        Map<Integer, List<Integer>>  treeForward = new HashMap<>();

        Map<Integer, List<Integer>>  treeBackward = new HashMap<>();


        for(int[] edge : edges ) {
            treeForward.computeIfAbsent(edge[0], key-> new ArrayList<>()).add(edge[1]);
            treeBackward.computeIfAbsent(edge[1], key-> new ArrayList<>()).add(edge[0]);
        }

        Queue<List<Integer>> alicQueue = new LinkedList<>();
        Queue<List<Integer>> bobQueue = new LinkedList<>();

        boolean visited[] = new boolean[amount.length];

        int aliceResult =0, bobResult =0;

        alicQueue.add(treeForward.get(0));
        visited[0] = true;
            aliceResult = amount[0];

        bobQueue.add(treeBackward.get(bob));


            bobResult = amount[bob];

        visited[bob] = true;

        while(!alicQueue.isEmpty() || !bobQueue.isEmpty()) {

            List<Integer> aliceTemp = alicQueue.poll();
            List<Integer> bobTemp = bobQueue.poll();
            int aliceNode =-1, bobNode =-1;
            if(!bobTemp.isEmpty()) {
                bobNode = bobTemp.get(0);
                if(treeBackward.get(bobNode) != null)
                    bobQueue.add(treeBackward.get(bobNode));
            }

            if(!aliceTemp.isEmpty()) {
                aliceNode = aliceTemp.get(0);
                if(treeForward.get(aliceNode) != null)
                    alicQueue.add(treeForward.get(aliceNode));
            }

            if((aliceNode != -1) && (bobNode != -1) &&  (bobNode == aliceNode)) {
                visited[bobNode] = true;

                aliceResult+= amount[bobNode]/2;
                bobResult+= amount[bobNode]/2;
            }else {
                if(aliceNode > 0 && !visited[aliceNode]) {
                    aliceResult+= amount[aliceNode];
                    visited[aliceNode] = true;
                }
                if(bobNode > 0 && !visited[bobNode]) {
                    bobResult+=amount[bobNode];
                    visited[bobNode] = true;
                }
            }

        }





        return Math.min(aliceResult,bobResult);
    }
}

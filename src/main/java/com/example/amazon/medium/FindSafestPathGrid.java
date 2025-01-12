package com.example.amazon.medium;

import java.util.*;

public class FindSafestPathGrid {
    public static void main(String[] args) {

        List<List<Integer>> grid = new ArrayList<>();

        grid.add(Arrays.asList(0,0,1));
        grid.add(Arrays.asList(0,0,1));
        grid.add(Arrays.asList(0,0,0));
//        grid.add(Arrays.asList(1,0,0,0));
       System.out.println( maximumSafenessFactor(grid) );
    }
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        int distToTheif[][] = new int[rows][cols];

        int gridArray[][] = new int[rows][cols];


        for(int i=0; i<rows;i++ ) {
            for(int j=0;j<cols;j++) {
                gridArray[i][j] = grid.get(i).get(j);
            }
        }

        if(gridArray[0][0] == 1 || gridArray[rows-1][cols-1] == 1){
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<rows;i++ ) {
            for(int j=0;j<cols;j++) {
               if(gridArray[i][j] ==1) {
                   queue.add(new int[]{i,j,0});
                   distToTheif[i][j] =0;

               }
               else {
                   distToTheif[i][j] = Integer.MAX_VALUE;
               }
            }
        }

        int dirInd[][] = new int[][]{ {0,1}, {0,-1}, {1,0}, {-1,0} };

        while(!queue.isEmpty()) {


            int size = queue.size();

            while(size-- > 0) {
                int cur[] = queue.poll();

                for(int[] curDir : dirInd) {
                    int curRow = cur[0] + curDir[0];
                    int curCol = cur[1] + curDir[1];
                    if(isValid(curRow, curCol, gridArray) &&   cur[2]+1 < distToTheif[curRow][curCol]) {
                        queue.add(new int[]{curRow, curCol, cur[2]+1});
                        distToTheif[curRow][curCol] = cur[2]+1;

                    }
                }

            }
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)-> b[2]-a[2]);
        priorityQueue.add(new int[]{0,0, distToTheif[0][0]});
        gridArray[0][0] = 2;


        while(!priorityQueue.isEmpty()) {

                int [] curr = priorityQueue.poll();
                for(int[] curIdx : dirInd) {
                    int curROw = curr[0] + curIdx[0];
                    int curCol = curr[1] + curIdx[1];
                    int currDist = curr[2];
                    if(curROw == rows-1 && curCol == cols-1 ) {
                        return currDist;
                    }
                    if(isValid(curROw, curCol, distToTheif) && gridArray[curROw][curCol]!= 2 ) {
                        priorityQueue.add(new int[]{curROw, curCol, Math.min(currDist, distToTheif[curROw][curCol])});
                        gridArray[curROw][curCol] = 2;
                    }
                }

        }



        return 0;
    }

    public static boolean isValid(int i, int j,  int gridArray[][]) {
        return (i >= 0 && j>=0 && i < gridArray.length && j <gridArray[i].length  );
    }
}

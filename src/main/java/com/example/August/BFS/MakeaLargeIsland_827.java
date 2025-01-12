package com.example.August.BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakeaLargeIsland_827 {

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();

        int region = 2;
        map.put(0,0);
        for(int i =0; i< grid.length; i++) {
            for(int j =0 ; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int temp =  fillisland(grid, i, j, region);
                    map.put(region, temp);
                    region++;
                }


            }
        }
        int ret = map.getOrDefault(2, 0);


        for(int i =0; i< grid.length; i++) {
            for(int j =0 ; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i>0 ? grid[i-1][j] : 0);
                    set.add(i<grid.length-1 ? grid[i+1][j] : 0);
                    set.add(j>0 ? grid[i][j-1] : 0);
                    set.add(j<grid.length-1 ? grid[i][j+1] : 0);
                    int area =1;
                    for(int val : set ) {
                        area+=  map.get(val);


                    }
                    ret = Math.max(area, ret);
                }



            }}

        // res = Math.max(oneCOunt, result[i][j]);
        return ret;
    }

    public int fillisland(int[][] grid, int i, int j, int region) {
        if(i<0 || i>=grid.length || j<0 || j>=grid.length || grid[i][j] != 1) {
            return 0;
        }

        int sum =1;
        grid[i][j] = region;
        sum +=  fillisland(grid, i+1,j+0, region );
        sum +=  fillisland(grid, i-1,j+0, region );
        sum +=  fillisland(grid, i+0,j+1, region );
        sum += fillisland(grid, i+1,j-1, region );

        return sum;
    }
}








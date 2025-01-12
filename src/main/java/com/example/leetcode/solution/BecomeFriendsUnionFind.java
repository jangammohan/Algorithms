package com.example.leetcode.solution;


import java.util.Arrays;

class UnionFind {
    int[] parent;
    int res;
    UnionFind(int size){
        parent = new int[size];
        res = size;
        for(int i=0; i< size; i++) {
            parent[i] = i;
        }

    }
    public int find(int i){
        if(parent[i] != i) {
            return find(parent[i]);
        }
        return parent[i];
    }

    public void union(int p1, int p2 ) {
        int a = find(p1);
        int b = find(p2);
        if(a!=b) {
            parent[a] =b;
            res--;
        }
    }

}
public class BecomeFriendsUnionFind {

    public static void main(String[] args) {
        int logs[][] = {{20190322,4,5},{20190101,0,1}, {20190104,3,4}, {20190107,2,3}, {20190211,1,5}, {20190224,2,4}, {20190301,0,3}
          , {20190312,1,2} };

        int n =6;

        System.out.println(earliestAcq(logs, n));
    }
    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]) );

        UnionFind uf = new UnionFind(n);


        for(int[] log : logs) {
            int timpestamp = log[0];
            int friend1 = log[1];
            int friend2 = log[2];
            uf.union(friend1, friend2);


            if(uf.res == 1) {
                return timpestamp;
            }
        }

        return -1;
    }

}

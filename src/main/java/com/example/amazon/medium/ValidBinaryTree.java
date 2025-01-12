package com.example.amazon.medium;

import java.util.*;

public class ValidBinaryTree {
    public static void main(String[] args) {
        int n =4;
        int[] leftChild= {3,-1,1,-1};
        int[] rightChild = {-1,-1,0,-1};
        System.out.print(validateBinaryTreeFailsForFewUseCases(n, leftChild, rightChild));

    }

    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        boolean childCOunt[] = new boolean[leftChild.length];

        for(int i : leftChild) {
            if(i != -1) {
                childCOunt[i] = true;
            }
        }

        for(int i : rightChild) {
            if(i != -1) {
                if(childCOunt[i]) {
                    return false;
                }
                childCOunt[i] = true;
            }
        }
        int root = -1;
        for(int i =0; i<n ;i++){
            if(!childCOunt[i]){
                if(root == -1){
                    root = i;
                }else {
                    return false;
                }
            }
        }
        if(root == -1){
            return false;
        }

        Queue<Integer> queue = new ArrayDeque<>() ;
        queue.add(root);
        boolean visited[] = new boolean[n];

        while(!queue.isEmpty()) {

            int current = queue.poll();
            visited[current] = true;
            if(leftChild[current] != -1){
                if(visited[leftChild[current]]) {
                    return false;
                }
                queue.add(leftChild[current]);
            }

            if(rightChild[current] != -1){
                if(visited[rightChild[current]]) {
                    return false;
                }
                queue.add(rightChild[current]);
            }

        }

        for(boolean bol : visited) {
            if(!bol) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateBinaryTreeFailsForFewUseCases(int n, int[] leftChild, int[] rightChild) {
        if(n<0){
            return false;
        }

        boolean[] child = new boolean[leftChild.length];
        for(int i =0; i<leftChild.length;i++) {
            if(leftChild[i] != -1){
                child[leftChild[i]] = true;
            }
            if(rightChild[i] != -1) {
                child[rightChild[i]] = true;
            }
        }

        int root =-1;
        for(int i=0; i< child.length; i++) {
            if(!child[i]) {
                root = i;
            }
        }

        if(root == -1){
            return false;
        }


        Set<Integer> result = new HashSet<>();
        result.add(root);
        for(int i=0; i<n; i++) {


            if(leftChild[i] > -1) {
                if (!result.contains(leftChild[i])) {
                    result.add(leftChild[i]);
                }else {
                    return false;
                }
            }

            if(rightChild[i] > -1) {
                if (!result.contains(rightChild[i])) {
                    result.add(rightChild[i]);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}

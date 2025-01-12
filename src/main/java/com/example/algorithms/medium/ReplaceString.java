package com.example.algorithms.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceString {
    public static void main(String[] args) {
        String s = "vmokgggqzp";
        int indices[] = {3,5,1};
        String sources[] = {"kg","ggq","mo"};
        String targets[] = {"s","so","bfr"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> table = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i<indices.length; i++) {
            if(s.startsWith(sources[i], indices[i])) {
                table.put(indices[i], i);
            }
        }
        int index =0;
        while(index < s.length()) {
            if(table.containsKey(index)) {
                stringBuilder.append(targets[table.get(index)]);
                index +=sources[table.get(index)].length() ;
            }else {
                stringBuilder.append(s.charAt(index));
                index++;
            }
        }

        return stringBuilder.toString();
    }
}

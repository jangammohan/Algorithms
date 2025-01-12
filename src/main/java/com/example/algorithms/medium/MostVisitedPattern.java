package com.example.algorithms.medium;

import java.util.*;

public class MostVisitedPattern {
    public static void main(String[] args) {
        String[] username = {"ua","ua","ua","ub","ub","ub"};
        int []timestamp = {1,2,3,4,5,6};
        String[] website = {"a","b","a","a","b","c"};

        Map<String, TreeMap<Integer, String>> users = new HashMap<>();

        for(int i =0; i< username.length; i++) {
            users.computeIfAbsent(username[i], key-> new TreeMap<>());
            users.get(username[i]).put(timestamp[i],website[i]);

        }

        Map<String, Integer> map = new HashMap<>();
        String res="";

        for(String usr : users.keySet()) {

            TreeMap<Integer, String> treeMap = users.get(usr);

            List<String> timestampsList = new LinkedList<>(treeMap.values());
            if(timestampsList.size()<3){ // no need to continue;
                continue;
            }

            for(int i=0; i<treeMap.size();i++) {
                for(int j=i+1; j< treeMap.size();j++){
                    for(int k=j+1;k< treeMap.size();k++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(timestampsList.get(i));
                        sb.append(" ");
                        sb.append(timestampsList.get(j));
                        sb.append(" ");
                        sb.append(timestampsList.get(k));
                        String temp = sb.toString();
                        map.computeIfPresent(temp, (key,value) -> value+1 );
                        map.computeIfAbsent(temp, (key) -> 1 );
                        if(res.equals("") || map.getOrDefault(res,0) < map.get(temp) || (map.getOrDefault(temp,0) == map.getOrDefault(res,0)  &&
                                res.compareTo(temp) > 0) ) {
                            res = temp;
                        }

                    }
                }
            }

        }
        System.out.print(Arrays.asList( res.split(" ")));

    }
}

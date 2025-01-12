package com.example.september.array;

import java.util.*;

public class SmallestCommonRegion_1257 {

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        Map<String, String> map = new HashMap<>();
        Set<String> reg1Set = new HashSet<>();
        for(List<String> list : regions) {

            for(int i =1; i< list.size(); i++) {
                map.put(list.get(i), list.get(0));
            }
        }
       // return  findSmallestReg(region1, region2, map);

        while(region1!= null) {
            reg1Set.add(region1);
            region1 = map.get(region1);
        }

        while(!reg1Set.contains(region2)) {
            region2 = map.get(region2);
        }
        return region2;
    }

    private String findSmallestReg(String reg1, String reg2, Map<String, String> map) {
        if(reg1.equals(reg2)) {
            return reg1;
        }
        String curReg1 = map.getOrDefault(reg1, reg1);
        if(curReg1.equals(reg2)) {
            return curReg1;
        }
        String curReg2 = map.getOrDefault(reg2, reg2);
        if(curReg1.equals(curReg2)) {
            return curReg2;
        }
        return findSmallestReg(curReg1, curReg2, map);
    }
}

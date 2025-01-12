package com.example.Top150.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};

        HashMap<String, List<String>> result = new HashMap<>();

        for(String st : str) {
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String temp = new String(ch);
           result.computeIfAbsent(temp, (key)-> new ArrayList<>()).add(st);
        }

        List<List<String>> res =  result.values().stream().collect(Collectors.toList());

        res.stream().forEach(System.out::println);
    }
}

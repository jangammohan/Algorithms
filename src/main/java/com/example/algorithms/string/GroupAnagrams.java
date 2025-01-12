package com.example.algorithms.string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String strs[] = {"",""}; //{"",""};//{"eat","tea","tan","ate","nat","bat"};

        groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, Set<String>> result = new HashMap<>();
        //findAnagrams(strs, 0, result);
//        List<List<String>> resultList =  result.values().stream().
//                map(ls -> new ArrayList<String>(ls) ).collect(Collectors.toList());

        List<List<String>> resultList = findAnagramsWithForLoop(strs);

        resultList.stream().forEach(ls -> System.out.println(ls.toString()));

        return resultList;
    }

    public static List<List<String>> findAnagramsWithForLoop(String[] strs ) {

        if(strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> result = new HashMap<>();
        for(String str : strs) {
            char tempArr[] = str.toCharArray();
            Arrays.sort(tempArr);
            String sortedStr = new String(tempArr);

            if(result.containsKey(sortedStr)) {

                result.get(sortedStr).add(str);

            }else {

                result.computeIfAbsent(sortedStr, key -> new ArrayList<>()).add(str);
            }
        }

    return new ArrayList<>(result.values());
    }

    public static void findAnagrams(String[] strs, int start, Map<String, Set<String>> result) {

        if(start >= strs.length) {
            return;
        }

        char tempArr[] = strs[start].toCharArray();
        Arrays.sort(tempArr);
        String sortedStr = new String(tempArr);

        if(result.containsKey(sortedStr)) {

            result.get(sortedStr).add(strs[start]);
            return;
        }

        result.computeIfAbsent(sortedStr, key -> new HashSet<>()).add(strs[start]);

        for(int i = start; i< strs.length; i++) {
            findAnagrams(strs, i+1, result);

        }

    }
}

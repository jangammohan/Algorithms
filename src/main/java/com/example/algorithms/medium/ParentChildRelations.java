package com.example.algorithms.medium;

import java.util.*;

class Relation {
    String parent;
    String child;
    Relation(String parent, String child) {
        this.parent = parent;
        this.child = child;
    }
}

public class ParentChildRelations {

    public static void main(String args[]) {
        List<Relation> rs = new ArrayList<>();
        rs.add(new Relation("animal", "mammal"));
        rs.add(new Relation("animal", "bird"));
        rs.add(new Relation("lifeform", "animal"));
        rs.add(new Relation("cat", "lion"));
        rs.add(new Relation("mammal", "cat"));
        rs.add(new Relation("animal", "fish"));


        List<String> childList;
        Map<String, List<String>> parentMap = new HashMap<>();
        Set<String> childSet = new HashSet<>();

        for(Relation relation : rs ) {
            childSet.add(relation.child);
            if(parentMap.containsKey(relation.parent)) {
                parentMap.get(relation.parent).add(relation.child);

            }
            else {
                childList = new ArrayList<>();
                childList.add(relation.child);
                parentMap.put(relation.parent, childList);
            }

        }
        String parentNode = "";
        for(String str : parentMap.keySet()) {
            if(!childSet.contains(str)) {
                parentNode = str;
                break;
            }
        }

       printTree(parentMap, parentNode, 0);


    }

    public static void printTree(Map<String, List<String>> parentMap, String parent, int level) {

        for(int i=0; i<level; i++) {
            System.out.print("\t");
        }

         System.out.println(parent);

        if(parentMap.get(parent) == null)
            return;

        List<String> childList = parentMap.get(parent);
       for(String st : childList) {
           printTree(parentMap, st, level+1);
       }
    }
}

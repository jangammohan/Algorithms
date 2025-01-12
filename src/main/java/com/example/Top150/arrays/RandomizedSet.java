package com.example.Top150.arrays;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> hashMap;

    List<Integer> listVal;

    Random random;

    //int current;
    Iterator<Integer> iterator;
    public RandomizedSet() {
        hashMap = new HashMap<>();
        listVal = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {

       if( hashMap.containsKey(val)) {
           return false;
       }
       hashMap.put(val, listVal.size());
       listVal.add(val);
       return true;
    }

    public boolean remove(int val) {

        if(!hashMap.containsKey(val)) {
            return false;
        }
        int index = hashMap.get(val);

        if(index < listVal.size() -1) {
            int lastVal = listVal.get(listVal.size()-1);
            hashMap.put(lastVal, index);
            listVal.set(index, lastVal);
        }
        hashMap.remove(val);
        listVal.remove(listVal.size()-1);
        return true;
    }

    public int getRandom() {

            return listVal.get(random.nextInt(listVal.size()));
        }


}

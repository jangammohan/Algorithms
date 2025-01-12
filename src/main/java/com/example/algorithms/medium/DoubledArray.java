package com.example.algorithms.medium;

import java.util.*;

public class DoubledArray {


    public static void main(String args[]) {
        int[] changed = {2,1,2,4,2,4};
       Queue<Integer> result = new LinkedList();
        Arrays.sort(changed);
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<changed.length;i++ ) {
           if( !result.isEmpty() && result.peek() == changed[i]) {
               ls.add(result.poll()/2);


           }else {
               result.add(changed[i]*2);

           }
        }

      // return result.isEmpty() && ls.size() > 0 ? ls.stream().mapToInt(Integer::intValue).toArray(): new int[0];

        System.out.print(ls);
    }
}

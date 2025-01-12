package com.example.amazon.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class PlatesBetweenCandles {
    public static void main(String[] args) {

        String s =  "***|**|*****|**||**|*"; //"**|**|***|";//"***|**|*****|**||**|*";
        int[][] queries =  {{1,17},{4,5},{14,17},{5,11},{15,16}} ;//{{2,5},{5,9}};//{{1,17},{4,5},{14,17},{5,11},{15,16}};

        int result[] = new int[queries.length];

        int strLen = s.length();

        /*for (int k=0; k< queries.length;k++) {
            Stack<Character> stack = new Stack();
            int start = queries[k][0];
            int end = (queries[k][1] <= strLen-1) ? queries[k][1] : (strLen-1);

            String subString = s.substring(start, end+1);
            stack.push('p');
            for(int j =0; j < subString.length(); ) {
                char lastElement = stack.peek();
                if(lastElement == '|' && subString.charAt(j) == '|' ) {
                    //stack.push(subString.charAt(j));
                    j++;
                    continue;
                }else if((lastElement == '|' && subString.charAt(j) == '*') || (lastElement == '*'  &&  subString.charAt(j) == '*') ) {
                    stack.push(subString.charAt(j));
                    j++;
                } else if(lastElement == '*' &&  subString.charAt(j) == '|' )  {
                    stack.pop();
                    result[k]++;
                } else if(subString.charAt(j) == '|' ) {
                    stack.push(subString.charAt(j));
                    j++;
                }else {
                    j++;
                }
            }
        }*/

       // System.out.println(Arrays.toString(platesBetweenCandles(s, queries)));

        System.out.println(Arrays.toString(platesBetweenCandlesString(s, queries)));
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int sum =0;
        for(int i =0; i< s.length(); i++) {
            if(s.charAt(i) == '*') {
                sum++;
            } else {
                treeMap.put(i, sum);
            }
        }

        int result[] = new int[queries.length];

        for(int j=0 ; j< queries.length; j++) {
            int start = queries[j][0];
            int end = queries[j][1];
             Integer left =   treeMap.ceilingKey(start);
            Integer right = treeMap.floorKey(end);

            if(left != null && right != null && left < right) {
                result[j] = treeMap.get(right)  - treeMap.get(left);
            }

        }

        return result;
    }

    public static int[] platesBetweenCandlesString(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for(int j=0; j<  queries.length; j++) {

            int left = 0;
            int right = 0;

                String str = s.substring( queries[j][0],  queries[j][1]+1);

                for(int i =0 ; i < str.length(); i++) {
                    if(str.charAt(i) == '|') {
                        left = i;
                        break;
                    }
                }

                for(int i = str.length()-1 ; i > 0; i--) {
                    if(str.charAt(i) == '|') {
                        right = i;
                        break;
                    }
                }

                while(left < right) {
                    if(str.charAt(left) == '*') {
                        result[j]++;
                    }
                    left++;
                }


        }

        return result;
    }
}

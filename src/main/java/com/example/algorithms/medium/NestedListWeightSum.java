package com.example.algorithms.medium;


import java.util.List;

interface NestedInteger {
  //Constructor initializes an empty nested list
         //    public NestedInteger();
              // Constructor initializes a single integer.
           //  public NestedInteger(int value);

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // Set this NestedInteger to hold a single integer.
              public void setInteger(int value);

              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              public void add(NestedInteger ni);

              // @return the nested list that this NestedInteger holds, if it holds a nested list
             // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
 }

public class NestedListWeightSum {

    public static void main(String[] args) {

    }

    public int depthSum(List<NestedInteger> nestedList, int depth, int result) {


        if(nestedList.isEmpty()) {
            return result;
        }

        for(NestedInteger nestedInteger : nestedList) {

            if(nestedInteger.isInteger()) {
                result+= nestedInteger.getInteger() * depth;
            } else {
                depthSum(nestedInteger.getList(), depth+1, result);
            }
        }


        return result;

    }
}

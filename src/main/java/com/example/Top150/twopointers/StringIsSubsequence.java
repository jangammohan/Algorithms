package com.example.Top150.twopointers;

public class StringIsSubsequence {

    public static void main(String[] args) {
        String s = "axc";
        String t ="ahbgdc";
        int index = 0;
        for(int i =0; i<s.length();i++) {
            index = t.indexOf(s.charAt(i), index);
            if(index < 0) {
                System.out.println("false");
                break;
            }else  {
                index++;
            }
        }

        System.out.println("true");
     }
}

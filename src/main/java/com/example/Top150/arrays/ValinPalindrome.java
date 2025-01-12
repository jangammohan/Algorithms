package com.example.Top150.arrays;

public class ValinPalindrome {
    public static void main(String[] args) {
        String s ="abcdef";
        int count =0;
        int left =0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {

            } else {
                if(count == 2) {
                    System.out.println("False");
                    break;
                }
                count++;
            }
            left++;
            right--;

        }

        System.out.print("True");
    }
}

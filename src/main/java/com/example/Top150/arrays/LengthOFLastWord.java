package com.example.Top150.arrays;

public class LengthOFLastWord {

    public static void main(String[] args) {
        String s = "a";
        s = s.trim();

        int result =0;
        if(s.length() == 0) {
            System.out.print("0");
            return;
        }
        int len = s.length()-1;
        while (len >=0 && s.charAt(len) != ' ') {
            len--;
            result++;
        }

        System.out.println(result);

    }
}

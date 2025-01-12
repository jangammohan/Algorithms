package com.example.november;

public class FancyString {
    public static void main(String[] args) {
        FancyString fs = new FancyString();
        System.out.println(fs.makeFancyString("aab"));
    }

    public String makeFancyString(String s) {

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int count =0;
        for(int i = 1 ; i<s.length();i++) {
            if(s.charAt(i-1) == s.charAt(i) ) {
                count++;
            }else {
                count =0;

            }
            if(count < 2){
                sb.append(s.charAt(i));
            }

        }

    return sb.toString();
    }
}

package com.example.october;

public class StringToIntergerConversion_8 {

    public static void main(String[] args) {
        StringToIntergerConversion_8 str = new StringToIntergerConversion_8();
        System.out.println(str.myAtoi("   -042"));
    }

    public int myAtoi(String s) {
        int index =0;
        int sign = 1;
        long result =0;
       s=  s.trim();
        if(s.length() == 0) {
            return (int)result;
        }


        if(index < s.length()  && (s.charAt(index) == '-' || s.charAt(index) == '+') ) {
            sign = (s.charAt(index++) == '-') ? -1 : 1;
        }

        while(index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + s.charAt(index++)-'0';
            if(result * sign >= Integer.MAX_VALUE || result * sign <= Integer.MIN_VALUE) {
                result = (sign == 1)  ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;
            }

        }


        return (int)result*sign;
    }
}

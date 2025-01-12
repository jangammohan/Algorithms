package com.example.Top150.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IntegerToRoman {

    public static void main(String[] args) {
        int num =20;
       // StringBuilder builder = new StringBuilder();


            Map<Integer, String> map = new HashMap<>();
            map.put(1, "I");
            map.put(4, "IV"); map.put(5, "V"); //map.put(6, "VI");
            map.put(9, "IX"); map.put(10,"X"); map.put(40, "XL");
            map.put(50, "L");map.put( 90, "XC");
            map.put(100, "C"); map.put(500, "D");
            map.put(1000, "M");map.put(400,"CD");
            map.put(900, "CM");

            Stack<String> stack = new Stack<>();

            int prefix = 1;
        while(num > 0) {
            int temp = num % 10;
            temp*=prefix;
            while (temp > 0) {

                if(map.get(temp) != null) {
                    stack.push(map.get(temp));
                    temp-=temp;
                } else if(temp % 10 == 0) {
                    while (temp > 0) {
                        if(map.get(temp) != null ) {
                            stack.push(map.get(temp));
                            temp-=temp;
                        }else {
                            stack.push("X");
                            temp-= 10;
                        }

                    }
                }

                else {
                    stack.push("I");
                    temp--;
                }
            }
            prefix*=10;
            num = num/10;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());

    }
}

package com.example.Top150.stack;

import java.sql.SQLOutput;
import java.util.Stack;

public class SimplyPath {

    public static void main(String[] args) {

        String path = "/home//foo/";

       int start = 1;
        Stack<String> result = new Stack<>();

        String[] arr = path.split("/");

        for (String st : arr) {

            if(st.equals("..") && !result.isEmpty()) {
                result.pop();
            } else if(!st.equals(".") && !st.equals("")) {
                result.push(st);
            }


        }

        if(result.isEmpty()){
            System.out.println("/");
        } else {
            StringBuilder sb = new StringBuilder();
            result.forEach(el -> {
                sb.append("/");
                sb.append(el);
            });
            System.out.println(sb.toString());
        }
    }
}

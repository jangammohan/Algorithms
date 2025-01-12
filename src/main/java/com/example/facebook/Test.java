package com.example.facebook;

public class Test {
    public static void main(String[] args) {
        String str =  null;
        try {
           // int  i = 1/0;
            System.out.println(str.equals("test"));
        }catch(Throwable ex) {
            System.out.println(ex.getStackTrace());
            System.out.println(ex.getMessage());
        }
    }
}

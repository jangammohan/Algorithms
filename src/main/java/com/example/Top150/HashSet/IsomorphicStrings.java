package com.example.Top150.HashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        if(s.length() != t.length()) {
            System.out.print(false);
        }

       int sarr[] = new int[128];
       int tarr[]  = new int[128];

        for(int i=0; i< s.length(); i++) {

            if(sarr[s.charAt(i)] != tarr[t.charAt(i)]) {
                System.out.print(false);
                return;
            }
            sarr[s.charAt(i)] = i;
            tarr[t.charAt(i)] = i;

        }
        System.out.print(true);
    }
}

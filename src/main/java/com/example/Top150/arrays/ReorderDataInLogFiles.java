package com.example.Top150.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        List<String> dig = Arrays.stream(logs).filter(val-> {

            int value = val.charAt(val.indexOf(" ")+1);
             return (value >=48 && value<=57);
        } ).collect(Collectors.toList());

        List<String> str = Arrays.stream(logs).filter(val-> {

            int value = val.charAt(val.indexOf(" ")+1)-'a';
            return (value >=0);
        } ).collect(Collectors.toList());

        Collections.sort(str, (a,b)->{
            int indexa = a.indexOf(" ");
            int indexb = b.indexOf(" ");

            return (a.substring(indexa).equals(b.substring(indexb)) ? a.substring(0,indexa).compareTo(b.substring(0, indexb))
                : a.substring(indexa+1).compareTo(b.substring(indexb+1)));
        });
        int i =0;
        for(String st : str  ) {
            logs[i++] = st;
        }
        for(String d : dig ) {
            logs[i++] = d;
        }


         System.out.println(logs);
    }
}

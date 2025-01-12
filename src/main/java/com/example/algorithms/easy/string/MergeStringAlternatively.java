package com.example.algorithms.easy.string;

public class MergeStringAlternatively {
    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 ="pq";
        int length1 = word1.length();
        int length2 =  word2.length();
        int length = Math.min(length1,length2);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(word1.charAt(i));
              sb.append(word2.charAt(i));

        }

        if(length1 != length2) {
            sb.append(length1 == length ? word2.substring(length, word2.length()) : word1.substring(length, word1.length()) );
        }

        System.out.print(sb.toString());

    }
}

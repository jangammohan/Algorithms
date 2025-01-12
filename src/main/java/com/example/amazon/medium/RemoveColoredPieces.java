package com.example.amazon.medium;

public class RemoveColoredPieces {

    public static void main(String[] args) {
        String colors = "ABBBBBBBAAA";
        int aliceCount = 0;
        int bobCount =0;
        char ch[] = colors.toCharArray();
        for (int i =1; i< colors.length()-1; i++) {
            if(ch[i] == ch[i-1] && ch[i+1] == ch[i]) {
                if(ch[i] == 'A') {
                    aliceCount++;
                } else {
                    bobCount++;
                }

            }

        }

        System.out.println( aliceCount > bobCount );
    }
}

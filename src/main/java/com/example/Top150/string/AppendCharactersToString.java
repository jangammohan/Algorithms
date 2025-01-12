package com.example.Top150.string;

public class AppendCharactersToString {

    public static void main(String[] args) {
        String s = "coaching";
        String t = "coding";


        int index =0;
        int startIndex =0;
        while(index < t.length() ) {
            startIndex = s.indexOf(t.charAt(index), startIndex);

            if(startIndex<0) {
                break;
            }
            startIndex++;
            index++;
        }
        System.out.print(t.length()-index);

    }

    public static int appendCharacters(String s, String t) {

        int dp[][] = new int[s.length()+1][t.length()+1];

        for(int i =1; i<s.length()+1;i++) {
            for(int j=1; j<t.length()+1;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return t.length() - dp[s.length()][t.length()] ;
    }
}

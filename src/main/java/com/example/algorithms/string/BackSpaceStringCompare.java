package com.example.algorithms.string;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t= "y#f#o##f";

        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
            StringBuilder stemp = new StringBuilder("");
            StringBuilder ttemp = new StringBuilder("");

            for(int i=0,j=0; i<s.length() || j<t.length(); j++,i++ ) {


                if(i < s.length()) {
                    if(s.charAt(i) == '#' && stemp.length() > 0) {
                        stemp.deleteCharAt(stemp.length()-1);
                    }
                    else if(s.charAt(i) != '#')  {
                        stemp.append(s.charAt(i));
                    }
                }

                if(j < t.length() ) {
                    if(t.charAt(j) == '#' && ttemp.length() > 0) {
                        ttemp.deleteCharAt(ttemp.length()-1);
                    }
                    else if(t.charAt(j) != '#') {
                        ttemp.append(t.charAt(j));
                    }
                }


            }


        return stemp.toString().equals(ttemp.toString());
    }

    //Leet Example

    public boolean  backspaceCompareLeet(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int skips =0;
        int skipt =0;

        while(i>0 && j>0){

            while(i>0) {
                if(s.charAt(i) == '#'){
                    skips++; i--;
                }else if(skips > 0){
                    skips--; i--;
                }else
                    break;
            }

            while(j>0) {
                if(t.charAt(j) == '#'){
                    skipt++; j--;
                }else if(skipt > 0){
                    skipt--; j--;
                }else
                    break;
            }

            if(i>=0 && j>=0 && t.charAt(j) != s.charAt(i)) {
                return false;
            }

            if((i>=0) != j>=0) {
                return false;
            }
    i--;j--;
        }


        return true;
    }

}

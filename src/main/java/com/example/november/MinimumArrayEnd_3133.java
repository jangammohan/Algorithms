package com.example.november;

public class MinimumArrayEnd_3133 {

    public static void main(String[] args) {
        MinimumArrayEnd_3133 min = new MinimumArrayEnd_3133();
        System.out.println(min.minEnd(3, 4));
    }

    public long minEnd(int n, int x) {

        int res = x;
        n--;
        int current = x;
        while(n>0) {
            if((current+1 & res) == x) {
                n--;
                res = current+1;
            }
            current = current+1;
        }

        return res;
    }


    //Leet Solution
    public long minEndLeet(int n, int x) {
        long ans = x;

        while(--n  > 0 ){
            ans = ans+1 | x;
        }
        return ans;
    }

}

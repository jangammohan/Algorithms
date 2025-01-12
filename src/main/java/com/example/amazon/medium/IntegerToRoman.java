package com.example.amazon.medium;

public class IntegerToRoman {

    public static void main(String[] args) {
        int nums[] =    {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL" ,"X", "IX", "V", "IV", "I"  };

        int num = 3;
        int i =0;
        StringBuilder sb = new StringBuilder();
        while(  num > 0) {

            while( num >= nums[i]) {
                num-=nums[i];
                sb.append(roman[i]);

            }
            i++;
        }

        System.out.print(sb.toString());
    }
}

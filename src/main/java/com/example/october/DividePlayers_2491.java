package com.example.october;

import java.util.Arrays;

public class DividePlayers_2491 {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int temp = skill[0] + skill[skill.length-1];

        int left =1;
        int right = skill.length-2;

        long capacity =0;

        while(left < right) {
            if(skill[left]+ skill[right] != temp) {
                return -1;
            }

            capacity+= (long) skill[left] * skill[right];
            left++;
            right--;
        }

        return capacity;

    }

}

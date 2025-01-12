package com.example.algorithms.easy.medium;

public class RoundBoundedCircle {

    public static void main(String[] args) {
        String s = "GL";

        RoundBoundedCircle round = new RoundBoundedCircle();
        System.out.print(round.isRobotBounded(s));
    }

    public boolean isRobotBounded(String instructions) {
        if(instructions.isEmpty() || instructions.length() == 1) {
            return false;
        }

        if(instructions.length() == 2 ) {
            if(instructions.contains("G") && (instructions.contains("L") || instructions.contains("R"))) {
                return true;
            }
            else {
                return false;
                }
        }
        int i= 0;
        int k = instructions.length()-1;
        while(i<k){
            if(instructions.charAt(i) == instructions.charAt(k)) {
                i++;
                k--;
                continue;

            }
            else {

                return false;
            }
        }

        return true;
    }
}

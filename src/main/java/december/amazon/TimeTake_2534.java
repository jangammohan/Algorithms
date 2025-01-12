package december.amazon;

import java.util.*;

public class TimeTake_2534 {

    public int[] timeTaken(int[] arrival, int[] state) {
        int result[] = new int[arrival.length];
        Queue<Integer> enterQ = new ArrayDeque<>();
        Queue<Integer> exitQ = new ArrayDeque<>();

        for(int val =0 ; val < state.length ; val++) {
            if(state[val] == 0) {
                enterQ.add(val);
            } else {
                exitQ.add(val);
            }
        }

        int prev = 1;
        int time =0;
        while(!enterQ.isEmpty() && !exitQ.isEmpty()) {

            if(arrival[enterQ.peek()] <= time && arrival[exitQ.peek()] <= time) {
                if(prev == 0) {
                    int index = enterQ.poll();
                    result[index] = time;
                } else {
                    int index = exitQ.poll();
                    result[index] = time;
                }
            } else if(arrival[enterQ.peek()] <= time && arrival[exitQ.peek()] > time) {
                int index = enterQ.poll();
                result[index] = time;
                prev = 0;

            }else if(arrival[enterQ.peek()] > time && arrival[exitQ.peek()] <= time) {
                int index = exitQ.poll();
                result[index] = time;
                prev = 1;

            } else {
                prev=1;
            }
            time++;

        }

        while(!enterQ.isEmpty()) {
            int index = enterQ.poll();
            result[index] = Math.max(arrival[index], time);
            time = Math.max(arrival[index], time)+1;
        }
        while(!exitQ.isEmpty()) {
            int index = exitQ.poll();
            result[index] = Math.max(arrival[index], time);
            time = Math.max(arrival[index], time)+1;
        }
        return result;
    }
}

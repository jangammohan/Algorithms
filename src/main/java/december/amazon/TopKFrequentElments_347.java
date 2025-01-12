package december.amazon;

import java.util.*;

public class TopKFrequentElments_347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int val : nums) {
            int count = (map.get(val) == null) ? 1 : map.get(val) +1;
            map.put(val, count);

        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> map.get(a)- map.get(b));

        for(int key : map.keySet()) {
            queue.add(key);
            if(queue.size() > k) {
                queue.poll();
            }

        }
        int i =0;
        int[] result = new int[queue.size()];
        while( !queue.isEmpty()){
            result[i++] = queue.poll();
        }


        return result;
    }
}

package december.amazon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KBigIndices_2519 {

    public static void main(String[] args) {
        KBigIndices_2519 big = new KBigIndices_2519();
        System.out.println(big.kBigIndices(new int[]{2,3,6,5,2,3}, 2));
    }

    public int kBigIndices(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int result =0;
        int n = nums.length;
        boolean prefix[] = new boolean[n];

        for(int i=0; i <nums.length; i++) {
            if(pq.size() == k && pq.peek() < nums[i]){
                prefix[i] = true;
            } else {
                pq.add(nums[i]);
            }
            if(pq.size() > k){
                pq.poll();
            }
        }

        pq.clear();

        for(int i = n-1; i>=0; i--){

            if(pq.size() == k && (pq.peek() < nums[i]) && prefix[i] ) {
                result++;
            } else{
                pq.add(nums[i]);
            }
            if(pq.size() > k) {
                pq.poll();
            }


        }



        return result;


    }
}

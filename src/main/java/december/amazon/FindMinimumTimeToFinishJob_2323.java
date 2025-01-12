package december.amazon;

import java.util.Arrays;

public class FindMinimumTimeToFinishJob_2323 {

    public static void main(String[] args) {
        FindMinimumTimeToFinishJob_2323 max = new FindMinimumTimeToFinishJob_2323();
        System.out.println(max.minimumTime(new int[]{5,2,4}, new int[]{1,7,5}));
    }

    public int minimumTime(int[] jobs, int[] workers) {

        int result =0;

        Arrays.sort(jobs);
        Arrays.sort(workers);

        for(int i =0 ; i < jobs.length; i++) {
            int temp = jobs[i] / workers[i];
            if(jobs[i] % workers[i] == 0) {
                result = Math.max(result, temp );
            }else {
                result = Math.max(result, temp+1);
            }
        }
        return result;
    }
}

package december.amazon;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {

    public int majorityElement(int[] nums) {
        int maxElment = nums[0];
        int count =1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val, map.getOrDefault(val, 0)+1);
            if(map.get(val) > count) {
                count = map.get(val);
                maxElment =  val;
            }

        }

        return maxElment;
    }


    //leetSolution
    public int majorityElementLeet(int[] nums) {

        int ans = nums[0];
        int count =1;
        for(int i =1; i< nums.length; i++) {
            if(ans == nums[i]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                ans = nums[i];
                count=1;
            }
        }
        return ans;
    }

}

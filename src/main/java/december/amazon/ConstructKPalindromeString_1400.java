package december.amazon;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeString_1400 {

    public boolean canConstruct(String s, int k) {

        if(s.length() < k) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int count =0 ;
        for(int val : map.values()) {
            if(val % 2 !=0) {
                count++;
            }
        }

        return count<=k;
    }
}

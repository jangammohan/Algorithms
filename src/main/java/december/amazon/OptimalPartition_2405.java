package december.amazon;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartition_2405 {

    public static void main(String[] args) {
        OptimalPartition_2405 optimal = new OptimalPartition_2405();
        System.out.println(optimal.partitionString("ssssss"));
    }

    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int result =1;
        for(char ch: s.toCharArray()) {
            if(!set.contains(ch)) {
                set.add(ch);
            } else {
                result++;
                set.clear();
                set.add(ch);
            }
        }
        return result;
    }
}

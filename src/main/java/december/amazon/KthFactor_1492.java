package december.amazon;

import java.util.ArrayList;
import java.util.List;

public class KthFactor_1492 {

    public static void main(String[] args) {
        KthFactor_1492 factor = new KthFactor_1492();
        System.out.println(factor.kthFactor(4,4));
    }

    public int kthFactor(int n, int k) {
        List<Integer> result  = new ArrayList<>();


        int temp = 1;

        while(temp <= n) {
            if(n % temp == 0) {
                result.add(temp);
                if(result.size() == k) {
                    return result.get(k-1);
                }
            }
            temp++;
        }
       return -1;
    }
}

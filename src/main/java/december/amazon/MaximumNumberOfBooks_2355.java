package december.amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaximumNumberOfBooks_2355 {

    public static void main(String[] args) {
        MaximumNumberOfBooks_2355 max = new MaximumNumberOfBooks_2355();
        System.out.println(max.maximumBooks(new int[]{0,0,5}));
    }


    //Fails some use cases
    public long maximumBooks(int[] books) {

        if(books.length == 1){
            return books[0];
        }
        long result =books[0];
        long curSofar = books[0];
        for(int i=1; i<books.length;i++){

            if(books[i] == books[i-1]) {
                if(books[i] > 0) {
                    curSofar+=books[i]-i;
                }
            }
            else if(books[i]>books[i-1]) {
                curSofar+= books[i];
            }else {
                curSofar = books[i] == 0 ? 0 : 1;
                curSofar = curSofar + books[i];

            }
            result = Math.max(result, curSofar);

        }

        return result ;
    }


    //leet solution with  dp & stack

     public long leet_maximumBooks(int[] books) {

        if(books.length ==1){
            return books[0];
        }
        int len = books.length;
        long dp[] = new long[len];
        long result =0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0; i<len; i++){

            while(!stack.isEmpty() && books[stack.peek()] >= books[i]-(i-stack.peek()) ) {
                stack.pop();
            }

            int lastIndex = stack.isEmpty() ? -1 : stack.peek();

            long taken = books[i] * (books[i] +1) / 2;
            long skip = (books[i]- (i-lastIndex)) * (long)(books[i]- (i-lastIndex) + 1) / 2;

            if(books[i] > i-lastIndex) {
                taken-=skip;
            }

            dp[i] = taken + ((lastIndex == -1) ?  0 : dp[lastIndex]);
            result = Math.max(result, dp[i]);
            stack.push(i);


        }
        return result;
     }
}

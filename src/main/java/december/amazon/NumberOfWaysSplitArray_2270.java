package december.amazon;

public class NumberOfWaysSplitArray_2270 {
    public static void main(String[] args) {
        NumberOfWaysSplitArray_2270 num = new NumberOfWaysSplitArray_2270();
        System.out.println(num.waysToSplitArray(new int[]{2,3,1,0}));
    }
    public int waysToSplitArray(int[] nums) {

        long  totalSum = 0;
        long  current =0;
        int result =0;
        for(int val : nums){
            totalSum+=val;
        }

        for(int i=0;i<nums.length-1; i++ ) {
            current+=nums[i];
            if(current>= totalSum-current){
                result++;
            }
        }

        return result;
    }
}

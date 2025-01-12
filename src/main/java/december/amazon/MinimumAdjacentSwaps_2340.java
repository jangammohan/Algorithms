package december.amazon;

public class MinimumAdjacentSwaps_2340 {
    public static void main(String[] args) {
        MinimumAdjacentSwaps_2340 swap = new MinimumAdjacentSwaps_2340();
        System.out.println(swap.minimumSwaps(new int[]{3,4,5,5,3,1}));
    }
    public int minimumSwaps(int[] nums) {

        int res =0;

        if(nums.length == 1){
            return res;
        }
        int smallIndex =0;
        int largeIndex =0;

        for(int i=1; i< nums.length; i++) {

            if(nums[smallIndex] > nums[i]) {
                smallIndex = i;
            }

            if(nums[largeIndex] <= nums[i]) {
                largeIndex =i;
            }

        }

        if(smallIndex < largeIndex ) {
            res = smallIndex + nums.length-1 - largeIndex;
        } else {
            res = smallIndex + nums.length-1 - largeIndex +1;
        }

        return res;
    }
}

package december.amazon;

public class MergeOperationsToTurnArray_2422 {

    public static void main(String[] args) {
        MergeOperationsToTurnArray_2422 merge = new MergeOperationsToTurnArray_2422();
        System.out.println(merge.minimumOperations(new int[]{1,2,3,4}));
    }

    public int minimumOperations(int[] nums) {
        int left =0;
        int right =nums.length-1;
        int result =0;
        while(left < right) {

            if(nums[left] == nums[right]) {
                left++;
                right--;
            } else if(nums[left] < nums[right]) {
                nums[left+1] = nums[left] + nums[left+1];
                left++;
                result++;
            } else {
                nums[right-1] = nums[right] + nums[right-1];
                result++;
                right--;
            }
        }

        return result;
    }

}

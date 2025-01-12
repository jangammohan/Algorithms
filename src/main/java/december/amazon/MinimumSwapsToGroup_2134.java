package december.amazon;

public class MinimumSwapsToGroup_2134 {

    public static void main(String[] args) {
        MinimumSwapsToGroup_2134 swap = new MinimumSwapsToGroup_2134();
        System.out.println(swap.minSwaps(new int[]{1,1,1,0,0,1,0,1,1,0}));
    }

    public int minSwaps(int[] nums) {
        int allOnes = 0;
        int n = nums.length;
        int newArr[] = new int[n *2];
        for(int i : nums){
            if(i == 1){
                allOnes++;
            }
        }

        for(int i =0; i< n*2 ; i++) {
            newArr[i] = nums[i%n];
        }

        int left = 0;
        int right = 0;
        int maxOnes = 0;
        int count =0;

        for(  ; right < newArr.length ; right++) {

            count+= newArr[right];



            if(right - left +1 > allOnes) {
                count-= newArr[left++];

            }

            maxOnes = Math.max(maxOnes, count);
        }
        return allOnes - maxOnes;
    }
}

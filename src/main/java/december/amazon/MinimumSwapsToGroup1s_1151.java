package december.amazon;

public class MinimumSwapsToGroup1s_1151 {
    public static void main(String[] args) {
        MinimumSwapsToGroup1s_1151 swap = new MinimumSwapsToGroup1s_1151();
        System.out.println(swap.Leet_minSwaps(new int[]{1,0,1,0,1,0,1,1,1,0,1,0,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1}));
    }

    public int minSwaps(int[] data) {

        //int result =0;

        int mid = data.length/2;

        int leftOne = 0;
        int leftZero =0;
        int rightOne = 0;
        int rightZero = 0;

        for(int i =0; i<=mid;i++) {
            if(data[i] == 1) {
                leftOne++;
            }else {
                leftZero++;
            }
        }

        for(int i = mid+1; i<data.length;i++) {
            if(data[i] == 1) {
                rightOne++;
            }else {
                rightZero++;
            }
        }

        if(rightOne > leftOne) {
            return Math.min(rightZero, leftOne);
        }

        return Math.min(leftZero, rightOne);
    }
//Leet Solution

    public int Leet_minSwaps(int[] data) {
        int allOnes = 0;

        for(int i : data){
            if(i == 1){
                allOnes++;
            }
        }

        int left = 0;
        int right = 0;
        int maxOnes = 0;
        int count =0;

        for(  ; right < data.length ; right++) {

            count+= data[right];



            if(right - left +1 > allOnes) {
                count-= data[left++];

            }

            maxOnes = Math.max(maxOnes, count);
        }
        return allOnes - maxOnes;
    }
}

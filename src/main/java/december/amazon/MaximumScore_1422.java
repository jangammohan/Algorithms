package december.amazon;

public class MaximumScore_1422 {
    public static void main(String[] args) {
        MaximumScore_1422 max = new MaximumScore_1422();
        System.out.println(max.maxScore("011101"));
    }

    // leet best solution 1ms
    public int maxScore(String s) {
      int zero = s.charAt(0) == '0' ? 1 : 0;
      int score = zero;
      int ones =0;
      for(int i =1; i< s.length()-1;i++){
          if(s.charAt(i) == '0'){
              zero++;
          }else {
              ones++;
              zero--;
          }

          if(zero > score){
              score = zero;
          }
      }

      ones+= s.charAt(s.length()-1) == '1'? 1:0;
      return ones + score;
    }

    //leetsolution
    public int leetmaxScore(String s) {
        int zeros =0;
        int ones =0;
        int result = Integer.MIN_VALUE;
        int i =0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeros++;
            } else {
                ones++;
            }

            if(i != s.length()-1) {
                result = Math.max(zeros-ones, result);
            }

            i++;
        }

        return result + ones;
    }

}

package preparation.arrays;

import java.util.Arrays;

public class Test24MaxProfit {

    public static void main(String[] args) {
        new Solution2().maxProfit(new int[]{1,2});
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        int[] maxToRight = new int[prices.length];

        maxToRight[prices.length-1] = -1;
        int max = maxToRight[prices.length-1];

        for(int i=prices.length-2;i>=0;i--){
            if(max < prices[i]){
                maxToRight[i] = -1;
                max = prices[i];
            }else{
                maxToRight[i] = max;
            }

        }

        Arrays.stream(maxToRight).map(i->i).forEach(i->System.out.print(i + " "));

        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(maxToRight[i]!=-1){
                maxProfit = Math.max(maxProfit, maxToRight[i] - prices[i]);
            }
        }
        return maxProfit;
    }
}

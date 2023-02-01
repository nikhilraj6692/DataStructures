package preparation.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Test09MinSubArrayRemovalToBeFullyDivisible {

    public static void main(String[] args) {
        System.out.println(new Solution().minSubarray(new int[]{1000000000,1000000000,1000000000},3));
    }
}

class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }
Map<String,String> map = new HashMap<>();
        map.values();
        int i=0, j=0;
        int subArraySum = sum%p;
        if(subArraySum == 0)
            return 0;
        int remainingSum = subArraySum;
        int minLength = Integer.MAX_VALUE;

        while(j<nums.length){
            //System.out.println(i + " " + j + " " + nums[j] + " " + remainingSum + " " + minLength);
            if(nums[j] <= remainingSum){
                remainingSum = remainingSum - nums[j];
                if(remainingSum == 0){
                    //found out the subArray
                    minLength = Math.min(minLength, j-i+1);
                    i++;
                    j=i;
                    remainingSum = subArraySum;
                }else{
                    //System.out.println("Incrementing j to " + j);
                    j++;
                    //System.out.println("Incremented j to " + j);
                }
            }else{
                //System.out.println("here");
                if(nums[j] > subArraySum){
                    j++;
                }else
                    i = j;
                remainingSum = subArraySum;
            }
        }

        if(minLength == nums.length)
            return -1;

        return minLength;
    }
}
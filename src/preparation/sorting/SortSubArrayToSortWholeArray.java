package preparation.sorting;

import java.util.Arrays;
import java.util.Map;

public class SortSubArrayToSortWholeArray
{

    public static void main(String[] args)
    {
        int[] result = Solution.findUnsortedSubarrayNaive(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
        System.out.println(result[0] + " " + result[1]);

        result = Solution.findUnsortedSubarrayOptimized(new int[]{2,3,1,4,5});
        System.out.println(result[0] + " " + result[1]);
    }

    static class Solution {

        /*
        simply sort the array and compare original array with old array and find start, end
         */
        public static int[] findUnsortedSubarrayNaive(int[] nums) {
            int[] duplicates = new int[nums.length];
            int count = 0;
            for(int num : nums) {
                duplicates[count++] = num;
            }

            Arrays.sort(nums);

            int start = -1;
            int end = -1;
            for(int i=0;i<nums.length;i++) {
                if(nums[i]!=duplicates[i]) {
                    if(start==-1) {
                        start = i;
                        end = i;
                    } else {
                        end = i;
                    }
                }
            }

            if(start==-1) {
                return new int[]{start, end};
            }
            return new int[]{start, end};
        }

        /*
        try to find unsorted array and find start and end. Now, find max and min
        in that unsorted array. it would be clear that if there is an element smaller
        after end, then move end to the position. similarly for max from left.
         */
        public static int[] findUnsortedSubarrayOptimized(int[] nums)
        {
            int start=-1, end=-1;

            //get first element unsorted from left
            for(int i=0;i<nums.length-1;i++) {
                if(nums[i]>nums[i+1]) {
                    start = i;
                    break;
                }
            }

            //get first element unsort from right
            for(int i=nums.length-1;i>0;i--) {
                if(nums[i]<nums[i-1]) {
                    end = i;
                    break;
                }
            }

            //get min and max from start and end
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=start;i<=end;i++) {
                min = Math.min(nums[i], min);
                max= Math.max(nums[i], max);
            }

            //get an index which is greater than minimum from left
            for(int i=start-1;i>=0;i--){
                if(nums[i] > min) {
                    start = i;
                }
            }

            //get an index which is smaller than maximum from right
            for(int i=start+1;i< nums.length;i++){
                if(nums[i] < max) {
                    end = i;
                }
            }
            return new int[]{start, end};
        }
    }
}

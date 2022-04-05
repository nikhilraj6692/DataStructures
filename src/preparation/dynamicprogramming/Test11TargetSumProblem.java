package preparation.dynamicprogramming;

/*
For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them
 to build the expression "+2-1"

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

This problem is nothing but count subset with minimum diff. this can be solved to s1-s2 = num
 */
public class Test11TargetSumProblem
{

    public static void main(String[] args)
    {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int target = 3;

        /*
        we know that sum of subset1, i.e.sm1 and sum of subset2, i.e. sm2 difference should be 1.
         so, sm1-sm2 = 1. Logically,
        sm1 + sm2 = array sum. Combining both equations, sm1 = (diff+array sum)/2. This reduces
        to finding out a subset whose
        sum is (diff+array sum)/2
         */

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }

        //from equation
        int finalSum = (target + sum) / 2;

        System.out.print(Test08CountSubsetsWithAGivenSum.countSubsets(arr, arr.length, finalSum));
    }
}

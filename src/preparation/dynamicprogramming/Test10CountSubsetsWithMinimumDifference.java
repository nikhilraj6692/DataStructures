package preparation.dynamicprogramming;

public class Test10CountSubsetsWithMinimumDifference {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3};
        int diff = 1;

        /*
        we know that sum of subset1, i.e.sm1 and sum of subset2, i.e. sm2 difference should be 1. so, sm1-sm2 = 1. Logically,
        sm1 + sm2 = array sum. Combining both equations, sm1 = (diff+array sum)/2. This reduces to finding out a subset whose
        sum is (diff+array sum)/2
         */

        int sum = 0;
        for(int i=0; i<arr.length; i++)
            sum+= arr[i];

        //from equation
        int finalSum = (1+sum)/2;

        System.out.print(Test08CountSubsetsWithAGivenSum.countSubsets(arr, arr.length, finalSum));
    }
}

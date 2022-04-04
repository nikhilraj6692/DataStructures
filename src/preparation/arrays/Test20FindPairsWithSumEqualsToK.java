package preparation.arrays;

import java.util.HashSet;
import java.util.Set;

public class Test20FindPairsWithSumEqualsToK
{

    public static void main(String[] args)
    {
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        getPairsCount(arr, sum);
    }

    private static void getPairsCount(int[] arr, int sum)
    {
        Set<Integer> set = new HashSet<>();
        for(int num : arr){
            if(set.contains(sum - num)){
                System.out.print("(" + (sum-num) + "," + num + "), ");
            }

            set.add(num);
        }
    }
}

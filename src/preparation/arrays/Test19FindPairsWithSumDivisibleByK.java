package preparation.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test19FindPairsWithSumDivisibleByK
{

    public static void main(String[] args)
    {
        int[] A = {5, 9, 36, 74, 52, 31, 42};
        int n = 7;
        int K = 3;
        System.out.print(countKdivPairs(A, n, K));
    }

    private static int countKdivPairs(int[] a, int n, int k)
    {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++)
        {
            int rem = a[i] % k;
            if (map.containsKey(k - rem))
            {
                count += map.get(k - rem).size();
            } else if (rem == 0 && map.containsKey(rem))
            {
                count += map.get(rem).size();
            }

            Set<Integer> tempSet = map.get(rem);
            if (null == tempSet)
            {
                tempSet = new HashSet<>();
            }

            tempSet.add(a[i]);
            map.put(rem, tempSet);

        }

        return count;
    }
}

package preparation.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/*
check if there is a subset whose sum is a given number. Solve via knapsack (same derrivation)
 */
public class Test06SubsetSumProblem
{

    public static void main(String[] args)
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        Set<Integer> s = new HashSet<>();
        if (isSubsetSum(set, n, sum, 0, s) == true)
        {
            System.out.println("Found a subset"
                + " with given sum");
        } else
        {
            System.out.println("No subset with"
                + " given sum");
        }

        System.out.print("\n------------------------\n");
        if (isSubsetSumWithOptimization(set, n, sum, dp) == true)
        {
            System.out.println("Found a subset"
                + " with given sum");
        } else
        {
            System.out.println("No subset with"
                + " given sum");
        }

        System.out.print("\n--------------------------------\n");
        if (isSubsetSumWithDP(set, n, sum, dp) == true)
        {
            System.out.println("Found a subset"
                + " with given sum");
        } else
        {
            System.out.println("No subset with"
                + " given sum");
        }

        System.out.print(min);
    }

    private static boolean isSubsetSumWithDP(int[] set, int n, int sum, boolean[][] dp)
    {
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < sum + 1; j++)
            {
                if (j == 0 && i == 0)
                {
                    dp[i][j] = true;
                } else if (j == 0)
                {
                    dp[i][j] = true;
                } else if (i == 0)
                {
                    dp[i][j] = false;
                } else if (set[i - 1] <= j)
                {
                    dp[i][j] = dp[i - 1][j - set[i - 1]] || dp[i - 1][j];
                } else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    private static boolean isSubsetSumWithOptimization(int[] set, int n, int sum, boolean[][] dp)
    {
        if (sum == 0)
        {
            return true; //because if sum is zero we can return an empty set
        }

        if (n == 0)
        {
            return false; //if set size is 0, sum with a positive integer can't be possible with
        }
        // any set. however if sum is 0 and
        // n=0 then empty set is possible

        if (dp[n][sum])
        {
            return dp[n][sum];
        }

        if (set[n - 1] <= sum)
        {
            dp[n][sum] = isSubsetSumWithOptimization(set, n - 1, sum - set[n - 1], dp)
                || isSubsetSumWithOptimization(set, n - 1, sum, dp);
            return dp[n][sum];
        } else
        {
            dp[n][sum] = isSubsetSumWithOptimization(set, n - 1, sum, dp);
            return dp[n][sum];
        }
    }

    private static int min = Integer.MAX_VALUE;

    private static boolean isSubsetSum(int[] set, int n, int sum, int sumTillNow, Set<Integer> s)
    {
        if (sumTillNow == sum)
        {
            System.out.print(s.toString());
        }

        if (sum == 0)
        {
            return true; //because if sum is zero we can return an empty set
        }

        if (n == 0)
        {
            return false;
        }//if set size is 0, sum with a positive integer can't be possible with any set. however
        // if sum is 0 and
        // n=0 then empty set is possible

        //System.out.print(set[n-1]);

        if (set[n - 1] <= sum)
        {
            //System.out.println("  ::: In positive");
            s.add(set[n - 1]);
            //System.out.println(s);
            boolean with = isSubsetSum(set, n - 1, sum - set[n - 1], sumTillNow + set[n - 1], s);
            if (!with)
            {
                s.remove(set[n - 1]);
            }
            //System.out.println(s);
            return with || isSubsetSum(set, n - 1, sum, sumTillNow + set[n - 1], s);
        } else
        {
            //System.out.println("  ::: In negative");
            boolean skip = isSubsetSum(set, n - 1, sum, sumTillNow + set[n - 1], s);
            if (!skip)
            {
                s.remove(set[n - 1]);
            }
            return skip;
        }


    }
}

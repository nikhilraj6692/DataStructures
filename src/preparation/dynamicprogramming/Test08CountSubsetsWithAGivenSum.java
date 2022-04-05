package preparation.dynamicprogramming;

/*
this is an exact variation of Test06SubsetSumProblem. the only thing is that we do not have to
shortcircuit the recursion or matrix
once we get true or false. instead we have to check for all occurrences and do a plus of with and
 without condition. Also, we have to
replace true by 1 and false by 0. 1 meaning that there can be one subset for combination of i amd
 j and 0 for no subset
 */
public class Test08CountSubsetsWithAGivenSum
{

    public static void main(String[] args)
    {
        int set[] = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = set.length;
        int[][] dp = new int[n + 1][sum + 1];

        System.out.print(countSubsets(set, n, sum));
        System.out.print("\n------------------------\n");
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < sum + 1; j++)
            {
                dp[i][j] = -1;
            }
        }
        System.out.print(countSubsetsWithOptimization(set, n, sum, dp));
        System.out.print("\n--------------------------------\n");
        System.out.print(countSubsetsWithDP(set, n, sum));

    }

    private static int countSubsetsWithOptimization(int[] set, int n, int sum, int[][] dp)
    {
        if (sum == 0 && n == 0)
        {
            return 1;
        }
        if (n == 0)
        {
            return 0; //if set size is 0, sum with a positive integer can't be possible with any
        }
        // set. however if sum is 0 and
        // n=0 then empty set is possible
        if (sum == 0)
        {
            return 1; //because if sum is zero we can return an empty set
        }

        if (dp[n][sum] != -1)
        {
            System.out.println("Optimized");
            return dp[n][sum];
        }

        if (set[n - 1] <= sum)
        {
            dp[n][sum] = countSubsetsWithOptimization(set, n - 1, sum - set[n - 1], dp)
                + countSubsetsWithOptimization(set, n - 1, sum, dp);
            return dp[n][sum];
        } else
        {
            dp[n][sum] = countSubsetsWithOptimization(set, n - 1, sum, dp);
            return dp[n][sum];
        }
    }

    public static int countSubsets(int[] set, int n, int sum)
    {
        if (sum == 0 && n == 0)
        {
            return 1;
        }
        if (n == 0)
        {
            return 0; //if set size is 0, sum with a positive integer can't be possible with any
        }
        // set. however if sum is 0 and
        // n=0 then empty set is possible
        if (sum == 0)
        {
            return 1; //because if sum is zero we can return an empty set
        }

        if (set[n - 1] <= sum)
        {
            return countSubsets(set, n - 1, sum - set[n - 1]) + countSubsets(set, n - 1, sum);
        } else
        {
            return countSubsets(set, n - 1, sum);
        }
    }


    private static int countSubsetsWithDP(int[] set, int n, int sum)
    {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < sum + 1; j++)
            {
                if (j == 0 && i == 0)
                {
                    dp[i][j] = 1;
                } else if (j == 0)
                {
                    dp[i][j] = 1;
                } else if (i == 0)
                {
                    dp[i][j] = 0;
                } else if (set[i - 1] <= j)
                {
                    dp[i][j] = dp[i - 1][j - set[i - 1]] + dp[i - 1][j];
                } else
                {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}

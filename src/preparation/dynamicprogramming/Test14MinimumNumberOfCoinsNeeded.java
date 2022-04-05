package preparation.dynamicprogramming;

public class Test14MinimumNumberOfCoinsNeeded
{

    public static void main(String[] args)
    {
        int coins[] = {9, 6, 5, 1};
        int size = coins.length;
        int sum = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, size, sum));
        System.out.print("\n------------------------------------\n");
        System.out.println("Minimum coins required is " + minCoinsRecursive(coins, size, sum));
        System.out.print("\n------------------------------------\n");
        //Arrays.sort(coins);
        System.out.println(
            "Minimum coins required is " + minCoinsMyRecursiveMethod(coins, size, sum, 0, 0));
    }

    static int minCoinsMyRecursiveMethod(int coins[], int n, int sum, int sumTillNow, int count)
    {
        if (sumTillNow == sum)
        {
            return count;
        } else if (sumTillNow > sum)
        {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            if ((sumTillNow + coins[i] <= sum))
            {
                min = Math.min(min,
                    minCoinsMyRecursiveMethod(coins, n, sum, sumTillNow + coins[i], count + 1));
            }
        }

        return min;
    }

    static int minCoinsAnotherMethod(int coins[], int m, int V)
    {
        // base case
        if (V == 0)
        {
            return 0;
        }

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i = 0; i < m; i++)
        {
            if (coins[i] <= V)
            {
                int sub_res = minCoins(coins, m, V - coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }

    private static int minCoinsRecursive(int[] coins, int size, int sum)
    {
        if (sum == 0)
        {
            return 0; //empty set condition
        }
        if (size == 0)
        {
            return Integer.MAX_VALUE - 1;
        }

        if (coins[size - 1] <= sum)
        {
            return Math.min(1 + minCoinsRecursive(coins, size, sum - coins[size - 1]),
                minCoinsRecursive(coins, size - 1, sum));
        } else
        {
            return minCoinsRecursive(coins, size - 1, sum);
        }
    }

    private static int minCoins(int[] coins, int size, int sum)
    {
        int[][] dp = new int[size + 1][sum + 1];

        for (int i = 0; i < size + 1; i++)
        {
            for (int j = 0; j < sum + 1; j++)
            {
                if (j == 0)
                {
                    dp[i][j] = 0; //minimum number of coins needed to find a sum of 0 will be 0
                } else if (i == 0)
                {
                    dp[i][j] = Integer.MAX_VALUE
                        - 1; //minimum no. of coins needed to find a sum of any value except 0
                }
                //and coins array as 0 is Integer.MAX_VALUE. -1 is to avoid overflow
                else if (coins[i - 1] <= j)
                {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else
                {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[size][sum];
    }
}

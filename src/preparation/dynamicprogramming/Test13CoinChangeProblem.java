package preparation.dynamicprogramming;

public class Test13CoinChangeProblem
{

    public static void main(String[] args)
    {
        int coins[] = {1, 2, 3};
        int size = coins.length;
        int wt = 4;
        System.out.println(countWays(coins, size, wt));
        System.out.print("\n-----------------------------------\n");
        System.out.println(countWaysByDP(coins, size, wt));
    }

    private static int countWaysByDP(int[] coins, int size, int wt)
    {
        int[][] dp = new int[size + 1][wt + 1];

        for (int i = 0; i < size + 1; i++)
        {
            for (int j = 0; j < wt + 1; j++)
            {
                if (j == 0)
                {
                    dp[i][j] = 1;
                } else if (i == 0)
                {
                    dp[i][j] = 0;
                } else if (coins[i - 1] <= j)
                {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else
                {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[size][wt];
    }

    private static int countWays(int[] coins, int size, int wt)
    {
        if (wt == 0)
        {
            return 1; //empty set condition
        }
        if (size == 0)
        {
            return 0;
        }

        if (coins[size - 1] <= wt)
        {
            return countWays(coins, size, wt - coins[size - 1]) + countWays(coins, size - 1, wt);
        } else
        {
            return countWays(coins, size - 1, wt);
        }
    }
}

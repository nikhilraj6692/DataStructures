package preparation.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Test22PrintShortesCommonSuperSequence
{

    public static void main(String[] args)
    {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        System.out.println(printShortestSuperSeq(X, Y));
    }

    private static String printShortestSuperSeq(String x, String y)
    {
        int[][] dp = new int[x.length() + 1][y.length() + 1];
        lcs(dp, x, y, x.length() + 1, y.length() + 1);

        Stack<Character> stack = new Stack<>();
        printLPS(dp, x, y, x.length(), y.length(), stack);

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty())
        {
            builder.append(stack.pop());
        }

        /*
        print all shortest super sequence with lcs dp...remember always print all sequences with
        lcs dp
         */
        Set<String> set = new HashSet<>();
        printAllLongestSubsequences(x, y, dp, x.length(), y.length(), "", set);
        set.stream().forEach(str -> System.out.print(str + " "));
        System.out.println();

        return builder.toString();
    }

    private static void printLPS(int[][] dp, String x, String y, int m, int n,
        Stack<Character> stack)
    {
        int i = m;
        int j = n;

        while (i > 0 && j > 0)
        {
            if (x.charAt(i - 1) == y.charAt(j - 1))
            {
                stack.push(x.charAt(i - 1));
                i--;
                j--;
            } else
            {
                if (dp[i - 1][j] > dp[i][j - 1])
                {
                    stack.push(x.charAt(i - 1));
                    i--;
                } else
                {
                    stack.push(y.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0)
        {
            stack.push(x.charAt(i - 1));
            i--;
        }
        while (j > 0)
        {
            stack.push(y.charAt(j - 1));
            j--;
        }
    }

    public static void printAllLongestSubsequences(String x, String y, int[][] dp, int row, int col,
        String output, Set<String> set)
    {
        if (row <= 0 || col <= 0)
        {
            while (row > 0)
            {
                output = x.charAt(row - 1) + output;
                row--;
            }
            while (col > 0)
            {
                output = y.charAt(col - 1) + output;
                col--;
            }

            //add it to set so that duplicate is removed
            set.add(output);
            return;
        }

        if (x.charAt(row - 1) == y.charAt(col - 1))
        {
            printAllLongestSubsequences(x, y, dp, row - 1, col - 1, x.charAt(row - 1) + output,
                set);
        } else
        {
            if (dp[row - 1][col] > dp[row][col - 1])
            {
                printAllLongestSubsequences(x, y, dp, row - 1, col, x.charAt(row - 1) + output,
                    set);
            } else if (dp[row - 1][col] < dp[row][col - 1])
            {
                printAllLongestSubsequences(x, y, dp, row, col - 1, y.charAt(col - 1) + output,
                    set);
            } else
            {
                printAllLongestSubsequences(x, y, dp, row - 1, col, x.charAt(row - 1) + output,
                    set);
                printAllLongestSubsequences(x, y, dp, row, col - 1, y.charAt(col - 1) + output,
                    set);
            }
        }


    }

    private static void lcs(int[][] dp, String x, String y, int m, int n)
    {
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0 || j == 0)
                {
                    dp[i][j] = 0;
                } else if (x.charAt(i - 1) == y.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}

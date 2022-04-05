package preparation.dynamicprogramming;

/*
In this problem , Given an array p[] which represents the chain of matrices such that the ith
matrix Ai is of dimension
p[i-1] x p[i]. We need to write a function MatrixChainOrder() that should return the minimum
number of multiplications
needed to multiply the chain.

Input: p[] = {40, 20, 30, 10, 30}
Output: 26000
There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
(A(BC))D --> 20*30*10(BC) + 40*20*10(ABC) + 40*10*30(ABCD)

Input: p[] = {10, 20, 30, 40, 30}
Output: 30000
There are 4 matrices of dimensions 10x20, 20x30, 30x40 and 40x30.
Let the input 4 matrices be A, B, C and D.  The minimum number of
multiplications are obtained by putting parenthesis in following way
((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30

Input: p[] = {10, 20, 30}
Output: 6000
There are only two matrices of dimensions 10x20 and 20x30. So there
is only one way to multiply the matrices, cost of which is 10*20*30

Here we will have to place k in such a way that the subarray from i to k-1 (inclusive) and k+1 to
 j-1 (inclusive) will multiply
as a matrix multiplication and their sum will give us minimum ans
 */
public class Test26MatrixChainMultiplication
{

    public static void main(String[] args)
    {
        int arr[] = new int[]{1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println(
            "Minimum number of multiplications is "
                + MatrixChainOrder(arr, 1, n - 1));

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                dp[i][j] = -1;
            }
        }
        System.out.println(
            "Minimum number of multiplications is "
                + MatrixChainOrderbyMemotization(arr, 1, n - 1, dp));
    }


    private static int MatrixChainOrderbyMemotization(int[] arr, int i, int j, int[][] dp)
    {
        if (dp[i][j] != -1)
        {
            System.out.println("Optimized");
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        /*
        it will run till j-1 only because think that if both k and j are at same place then how
        will matrix multiplication
        take place. k, j and i all three should be at some distinct index. So, took k from 1 to
        j-1 (inclusive)
         */
        for (int k = i; k < j; k++)
        {
            int temp =
                MatrixChainOrderbyMemotization(arr, i, k, dp) + MatrixChainOrderbyMemotization(arr,
                    k + 1, j, dp);
            ans = Math.min(arr[i - 1] * arr[k] * arr[j] + temp, ans);
            dp[i][j] = ans;
        }

        return dp[i][j];
    }

    private static int MatrixChainOrder(int[] arr, int i, int j)
    {
        if (i >= j)
        {
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        /*
        it will run till j-1 only because think that if both k and j are at same place then how
        will matrix multiplication
        take place. k, j and i all three should be at some distinct index. So, took k from 1 to
        j-1 (inclusive)
         */
        for (int k = i; k < j; k++)
        {
            int temp =
                arr[i - 1] * arr[k] * arr[j] + MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr,
                    k + 1, j);
            ans = Math.min(temp, ans);
        }

        return ans;

    }
}

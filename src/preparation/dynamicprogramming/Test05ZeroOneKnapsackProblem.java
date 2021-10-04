package preparation.dynamicprogramming;

import java.util.Arrays;

public class Test05ZeroOneKnapsackProblem {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        int[][] mw = new int[n+1][W+1];
        for(int i = 0; i < n + 1; i++)
            for(int j = 0; j < W + 1; j++)
                mw[i][j] = -1;
        System.out.println(knapSack(W, wt, val, n, mw));

        //from memotization, we can derive matrix algo (top down approach).

        System.out.println(knapSackByTopDown(W, wt, val, n));
    }


    static int knapSack(int W, int wt[],
                        int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                            = Math.max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    private static int knapSackByTopDown(int W, int[] wt, int[] val, int n) {
        int mw[][] = new int[n + 1][W + 1];

       //replace conditions by recursion
        for(int i=0;i<n+1;i++){
            for(int w=0;w<W+1;w++){
                if(i==0 || w ==0){
                    mw[i][w]=0;
                }else if(wt[i-1]<=w) {
                    mw[i][w] = Math.max(val[i-1] + mw[i - 1][w - wt[i - 1]], mw[i - 1][w]);
                }else{
                    mw[i][w] = mw[i-1][w];
                }
            }
        }

        return mw[n][W];

    }

    /*
    for memotization we take a matrix mw[n][w]
     */
    private static int knapSack(int w, int[] wt, int[] val, int n, int[][] mw) {
        if(n==0 || w==0)
            return 0;

        if(mw[n][w]!=-1)
            return mw[n][w];

        if(wt[n-1] <= w){
            //either we choose or not choose an element
            mw[n][w] = Math.max(val[n-1] + knapSack(w- wt[n-1], wt,  val, n-1, mw), knapSack(w, wt, val, n-1, mw));
            return mw[n][w];
        }
        else{
            mw[n][w]= knapSack(w, wt, val, n-1, mw);
            return mw[n][w];
        }
    }

}

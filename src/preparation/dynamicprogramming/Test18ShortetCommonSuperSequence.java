package preparation.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class Test18ShortetCommonSuperSequence {
    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";
        int m = X.length(), n = Y.length();

        /*
        the merged sequence can be in order but not necessarily in sequence, like ABCBDCABA, ABDCABDAB, and ABDCBDABA. If we look
        at the answer closely for shortest common supersequence, the length would be the length of the merged string-(LCS) since
        for same characters we will write letter only one time and for remaining we would copy and write them in order but not
        necessarily in sequence
         */
        System.out.print("The length of the shortest common supersequence is "
                + SCSLengthUsingLCS(X, Y, m, n));

        System.out.println("\n==============================\n");
        int[][] dp = new int[m + 1][n + 1];
        System.out.print("\nThe length of the shortest common supersequence is " + populateMatrix(X, Y, m, n, dp));


    }



    private static int populateMatrix(String x, String y, int m, int n, int[][] dp) {

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                //if any one is zero then ans will be the length of second string...here it is i and j so have to be written
                //in this way only
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;

                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    //minimum is asked and since it is super sequence so even if not matched, we have to do a plus one
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                }

            }
        }

        return dp[m][n];

    }

    private static int SCSLengthUsingLCS(String x, String y, int m, int n) {
        int mergedStringLEngth = (x + y).length();
        int LCSlength = Test15LongestCommonSubSequence.lcsDP(x.toCharArray(), y.toCharArray(), m, n);
        return mergedStringLEngth - LCSlength;
    }
}

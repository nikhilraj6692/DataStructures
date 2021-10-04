package preparation.dynamicprogramming;

import java.util.Arrays;

/*
In this problem, we have to find longest repeating sub sequence such that the repeating sub sequence order should be maintained
but it need not be continuous (sub sequence property). eg, for ABBA, the only repeating subsequence would be either A or B,
for aabb, it can be ab. To solve this we will have to use lcs. We will take second string same as the first one and we will
increase the count only when characters are same and i!=j

ATACTCGGA
ATACTCGGA
 */
public class Test23LongestRepeatingSequence {
    public static void main(String[] args) {
        String str = "aaaa";
        int m = str.length();
        int[][] dp = new int[m+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("The length of the largest subsequence that"
                + " repeats itself is : "
                + findLongestRepeatingSubSeq(str.toCharArray(), m, m, dp));

        dp = new int[m+1][m+1];
        System.out.println("The length of the largest subsequence that"
                + " repeats itself is : "
                + findLongestRepeatingSubSeqByDP(str.toCharArray(), m, m, dp));

        System.out.print(printSubsequence(str.toCharArray(), m, m, dp, ""));
    }

    private static String printSubsequence(char[] arr, int row, int column, int[][] dp, String output) {

        while(row>0 && column>0){
            if(arr[row-1] == arr[column-1] && row!=column){
                output= arr[row-1] + output;
                row--;
                column--;
            }else{
                if(dp[row-1][column] > dp[row][column-1]){
                    row--;
                } else {
                    column--;
                }
            }

        }
        return output;
    }

    private static int findLongestRepeatingSubSeqByDP(char[] toCharArray, int m, int n, int[][] dp) {

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;

                else if (toCharArray[i-1] == toCharArray[j-1] && i!=j){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }

        return dp[m][n];
    }

    private static int findLongestRepeatingSubSeq(char[] toCharArray, int m, int n, int[][] dp) {
        if(dp[m][n]!=-1)
            return dp[m][n];

        if(m==0 || n==0)
            return 0;

        if(toCharArray[m-1] == toCharArray[n-1] && m-1!=n-1){
            dp[m][n] = 1+findLongestRepeatingSubSeq(toCharArray, m-1, n-1, dp);
            return dp[m][n];
        }else{
            dp[m][n] = Math.max(findLongestRepeatingSubSeq(toCharArray, m-1, n, dp),
                    findLongestRepeatingSubSeq(toCharArray, m, n-1, dp));
            return dp[m][n];
        }
    }
}

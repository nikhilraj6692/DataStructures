package preparation.dynamicprogramming;

public class Test20LongestPalindromeSequence {
    public static void main(String[] args) {
        /*
        one way is to convert it into lcs form, reverse the string and find lcs of both str and reverse of string and that would be
        the answer
         */
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d\n", lps(seq.toCharArray(), new StringBuilder(seq).reverse().toString().toCharArray()));

        /*
        another way is that if last and first characters are same, then take them otherwise max of (leave first and take second,
        take first and leave second)
         */
        int[][] memotized = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                memotized[i][j] = -1;
            }
        }
        memotized[0][0] = 0;
        System.out.printf("The length of the LPS is %d\n", lps(seq.toCharArray(), 0, n-1, memotized));

        /*
        to print palindromic subsequence...first create matrix with lcs approach and then print all subsequences
         */

        System.out.print("length of lps is : " + findLongestPalindrome(seq.toCharArray(), seq.length(), 0, n-1));
    }

    private static int lps(char[] toCharArray, int i, int j, int[][] dp) {
        if(dp[i][j]!=-1)
            return dp[i][j];

        if(i>j)
            return 0;

        // with one character, there can be a palindrome
        if(i==j)
            return 1;

        if(toCharArray[i] == toCharArray[j]){
            //2 beacuse if characters are same and we consider them then length would be char at i and char at j, i.e. 2
            dp[i][j] = 2 + lps(toCharArray, i+1, j-1, dp);
            return dp[i][j];
        }else{
            dp[i][j] = Math.max(lps(toCharArray, i+1, j, dp), lps(toCharArray, i, j-1, dp));
            return dp[i][j];
        }

    }

    private static int lps(char[] toCharArray, char[] toCharArray1) {
        int lcsLength = Test15LongestCommonSubSequence.lcsDP(toCharArray, toCharArray1, toCharArray.length, toCharArray1.length);
        return lcsLength;
    }

    private static int findLongestPalindrome(char[] str, int len, int s, int e){
        if(s>e){
            return 0;
        }
        else if(s==e){
            return 1;
        }

        if(str[s]==str[e]){
            return 2+findLongestPalindrome(str,len,s+1,e-1);
        }else{
            return Math.max(findLongestPalindrome(str, len, s+1,e), findLongestPalindrome(str, len, s, e-1));
        }
    }
}

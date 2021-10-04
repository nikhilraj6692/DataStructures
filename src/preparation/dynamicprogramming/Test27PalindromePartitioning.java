package preparation.dynamicprogramming;

/*
we have to partition palindrome in one or more cuts such that each word is a palindrome
 */
public class Test27PalindromePartitioning {
    public static void main(String[] args) {
        String str = "ababbbabbababa";
        int n = str.length();
        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is " + minPalPartion(str, 0, str.length() - 1));

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;

        System.out.println("Min cuts needed for "
                + "Palindrome Partitioning is " + minPalPartionByMemotization(str, 0, str.length() - 1, dp));
    }

    /*
    can also be memotized for temp1, temp2 individually also
     */
    private static int minPalPartionByMemotization(String str, int i, int j, int[][] dp) {
        if(i>=j || isPalindrome(str.substring(i,j+1))){
            dp[i][j] = 0;
        }

        if(dp[i][j]!=-1) {
            System.out.println("Optimized");
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp1 = minPalPartionByMemotization(str, i, k,dp);
            int temp2 = minPalPartionByMemotization(str, k+1, j,dp);
            min = Math.min(min, temp1+temp2+1);
            System.out.println(str.substring(i,k+1) + " " + str.substring(k+1, j+1));
            dp[i][j] = min;
        }

        return dp[i][j];
    }

    private static int minPalPartion(String str, int i, int j) {
        //no partition further if any one of two condition
        if(i>=j || isPalindrome(str.substring(i,j+1))){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp = minPalPartion(str, i, k) + minPalPartion(str, k+1, j) + 1;
            min = Math.min(min, temp);
            //System.out.println(str.substring(i,k+1) + " " + str.substring(k+1, j+1) + " " + temp + " " + min);
        }

        return min;
    }

    private static boolean isPalindrome(String str) {
        if(str.equals(new StringBuilder(str).reverse().toString()))
            return true;
        return false;
    }
}

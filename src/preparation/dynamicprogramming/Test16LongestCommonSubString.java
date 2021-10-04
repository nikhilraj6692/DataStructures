package preparation.dynamicprogramming;

/*
will be same as test15longestcommonsubsequence, but only thing is that if the two characters will not match, then we have to return 0
because we when two characters will not be matched, then sequence of substring should break;
 */
public class Test16LongestCommonSubString {
    public static void main(String[] args) {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        int max=0;
        /*System.out.println(LCSubStrRecursive(X.toCharArray(),
                Y.toCharArray(), m,
                n, max));*/

        System.out.println(LCSubStrDP(X.toCharArray(),
                Y.toCharArray(), m,
                n));
    }

    private static int LCSubStrDP(char[] toCharArray, char[] toCharArray1, int m, int n) {
        int[][] memotized = new int[m+1][n+1];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)
                    memotized[i][j] = 0;
                else if(toCharArray[i-1]==toCharArray1[j-1]){
                    memotized[i][j] = 1+memotized[i-1][j-1];
                    max = Integer.max(max, memotized[i][j]);
                }else{
                    memotized[i][j] = 0;
                }
            }
        }

        return max;
    }



    /*this code has to work but is not working somehow*/
    private static int LCSubStrRecursive(char[] toCharArray, char[] toCharArray1, int m, int n, int max) {
        if(m==0 || n==0)
            return max;

        if(toCharArray[m-1]==toCharArray1[n-1]){
            max = LCSubStrRecursive(toCharArray, toCharArray1, m-1, n-1, max+1);
        }else {
            max = Math.max(max, Math.max(LCSubStrRecursive(toCharArray, toCharArray1, m, n - 1, 0),
                    LCSubStrRecursive(toCharArray, toCharArray1, m - 1, n, 0)));
        }

        return max;

    }
}

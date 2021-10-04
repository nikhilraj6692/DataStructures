package preparation.dynamicprogramming;

public class Test15LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "bebdeeedaddecebbbbbabebedc";
        String s2 = "abaaddaabbedeedeacbcdcaaed";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        /*
        if characters at n-1 position are equal, then do a 1+fn() with n-1 and m-1, but if not equal then take one with same len
        and another one with m-1 and vice versa
         */
        int[][] memotized = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                memotized[i][j] = -1;
            }
        }
        memotized[0][0] = 0;
        System.out.println("Length of LCS is" + " " +
                lcs( X, Y, m, n, memotized ) );

        System.out.print("\n---------------------------\n");

        System.out.println("Length of LCS is" + " " +
                lcsDP( X, Y, m, n) );
    }

    public static int lcsDP(char[] x, char[] y, int m, int n) {
        int[][] memotized = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)
                    memotized[i][j] = 0;
                else if(x[i-1]==y[j-1]){
                    memotized[i][j] = 1+memotized[i-1][j-1];
                }else{
                    memotized[i][j] = Math.max(memotized[i][j-1], memotized[i-1][j]);
                }
            }
        }

        return memotized[m][n];
    }

    public static int lcs(char[] x, char[] y, int m, int n, int[][] memotized) {
        if(memotized[m][n]!=-1){
            return memotized[m][n];
        }
        if(m==0 || n==0) {
            return 0;
        }

        if(x[m-1] == y[n-1]){
            memotized[m][n] = 1+lcs(x,y,m-1, n-1, memotized);
            return memotized[m][n];
        }

        else {
            memotized[m][n] = Math.max(lcs(x, y, m - 1, n, memotized), lcs(x, y, m, n - 1, memotized));
            return memotized[m][n];
        }
    }
}

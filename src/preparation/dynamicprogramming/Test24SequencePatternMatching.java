package preparation.dynamicprogramming;

/*
in this we have to check whether s2 is a sub sequence of s1 or not. just check lcs of both and if length is equal to s2 length
then return true
 */
public class Test24SequencePatternMatching {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GTA";

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
        System.out.println(
                Test15LongestCommonSubSequence.lcs( X, Y, m, n, memotized ) == s2.length() ? true : false);

        System.out.print("\n---------------------------\n");

        System.out.println(
                Test15LongestCommonSubSequence.lcsDP( X, Y, m, n) == s2.length() ? true : false);
    }
}

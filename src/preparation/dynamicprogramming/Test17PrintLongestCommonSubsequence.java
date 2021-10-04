package preparation.dynamicprogramming;

import preparation.util.Pair;

import java.util.*;

public class Test17PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "AGTGATG";
        String Y = "GTTAG";
        int m = X.length();
        int n = Y.length();

        printSequence(X, Y, m, n);

    }

    public static void printSequence(String x, String y, int m, int n) {
        int[][] memotized = new int[m+1][n+1];

        System.out.println("LCS length is " +
                lcsDP(x.toCharArray(), y.toCharArray(), m, n, memotized));

        //print string through memotized array
        Stack<Character> stack = new Stack<>();
        printLongestSubsequenceSum(x, y, m, n, memotized, stack);
        while(!stack.isEmpty())
            System.out.print(stack.pop());
        System.out.println();
        printAllLongestSubsequences(x, y, memotized, x.length(), y.length(), "");
    }

    public static void printAllLongestSubsequences(String x, String y, int[][] memotized, int row, int col, String output) {
        if(row<=0 || col<=0) {
            //add it to set so that duplicate is removed
            System.out.println(output);
            return;
        }

        if(x.charAt(row-1) == y.charAt(col-1)){
            printAllLongestSubsequences(x,y,memotized,row-1, col-1, output+x.charAt(row-1));
        }
        else {
            if (memotized[row - 1][col] > memotized[row][col - 1]) {
                printAllLongestSubsequences(x,y,memotized,row-1, col, output);
            } else if (memotized[row - 1][col] < memotized[row][col - 1]) {
                printAllLongestSubsequences(x,y,memotized,row, col-1, output);
            } else {
                printAllLongestSubsequences(x,y,memotized,row-1, col, output);
                printAllLongestSubsequences(x,y,memotized,row, col-1, output);
            }
        }



    }

    private static boolean isValid(int pos, int maxPos) {
        return pos>=0 && pos<=maxPos;
    }


    public static int lcsDP(char[] x, char[] y, int m, int n,int[][] memotized ) {

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

    public static void printLongestSubsequenceSum(String x, String y, int m, int n, int[][] memotized, Stack<Character> stack) {
        int i=m, j=n;

        while(i>0 && j>0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                stack.push(x.charAt(i-1));
                i--;
                j--;
            }else {
                if(memotized[i-1][j]>memotized[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }
    }
}

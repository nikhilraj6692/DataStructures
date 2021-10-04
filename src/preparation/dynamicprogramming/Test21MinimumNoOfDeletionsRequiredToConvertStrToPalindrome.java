package preparation.dynamicprogramming;

public class Test21MinimumNoOfDeletionsRequiredToConvertStrToPalindrome {
    public static void main(String[] args) {
        String X = "ACBCDBAA";

        Test17PrintLongestCommonSubsequence.printSequence(X, new StringBuilder(X).reverse().toString(), X.length(), X.length());

        /*
        same as test19 + test20
         */
        System.out.print("The minimum number of deletions required is " +
                minDeletions(X.toCharArray(), new StringBuilder(X).reverse().toString().toCharArray()));
    }

    public static int minDeletions(char[] toCharArray, char[] toCharArray1) {
        int lcsLength = Test15LongestCommonSubSequence.lcsDP(toCharArray, toCharArray1, toCharArray.length, toCharArray1.length);
        return toCharArray.length - lcsLength;
    }
}

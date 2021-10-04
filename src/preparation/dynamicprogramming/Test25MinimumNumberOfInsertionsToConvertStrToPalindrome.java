package preparation.dynamicprogramming;

/*
In Test21, we did the problem to find minimum deletion to convert string to palindrome. Think that if there are 'n' deletions to
convert a string to palindrome, then if we do the reverse and add same number of characters to the string, it will become a
palindrome. Summarizing, minimum number of deletions is equal to minimum number of insertions
 */
public class Test25MinimumNumberOfInsertionsToConvertStrToPalindrome {
    public static void main(String[] args) {
        String str = "geeks";

        System.out.print("The minimum number of insertions required is " + findMinInsertionsLCS(str));
    }

    private static int findMinInsertionsLCS(String str) {
        return Test21MinimumNoOfDeletionsRequiredToConvertStrToPalindrome.minDeletions(str.toCharArray(),
                new StringBuilder(str).reverse().toString().toCharArray());
    }

}

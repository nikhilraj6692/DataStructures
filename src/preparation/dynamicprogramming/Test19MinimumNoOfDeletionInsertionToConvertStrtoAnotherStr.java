package preparation.dynamicprogramming;

public class Test19MinimumNoOfDeletionInsertionToConvertStrtoAnotherStr {
    public static void main(String[] args) {
        String str1 = new String("heap");
        String str2 = new String("pea");

        /*
        If we find lcs length, then the remaining character has to be inserted and deleted. Since we have to convert A to B, so from
        A, it would be deletion and from second B it would be insertion
         */
        // Function Call
        printMinDelAndInsert(str1, str2);
    }

    private static void printMinDelAndInsert(String str1, String str2) {
        int lcsLength = Test15LongestCommonSubSequence.lcsDP(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
        System.out.print("Insertion :: " + (str2.length() - lcsLength) + " Deletion :: " + (str1.length()-lcsLength));
    }
}

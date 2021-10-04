package preparation.dynamicprogramming;

import java.util.*;

public class Test29PrintAllSubSequencesOfAString {
    public static void main(String[] args) {
        String s = "job";
        printAllSequences(s, "");

        System.out.println("\n===================\n");
        Set<String> set = new HashSet<>();
        printAllSequencesPermutations(s, "", set);
        set.stream().forEach(str -> System.out.println(str));

        System.out.println("\n===================\n");
        set = new LinkedHashSet<>();
        printSubSeqByBakctracking(s, set, "", 0);
        set.stream().forEach(str -> System.out.println(str));
    }

    /*
    in backtracking remember that we have remove last added variable from the output so that the recursion will take place
     */
    private static void printSubSeqByBakctracking(String input, Set<String> set, String output, int index) {
        if(null!=output)
            set.add(output);

        for(int i=index; i<input.length();i++){
            output+= input.charAt(i);
            printSubSeqByBakctracking(input, set, output, i+1);
            output = output.substring(0, output.length()-1);
        }
    }

    private static void printAllSequencesPermutations(String input, String output, Set<String> set) {
       if(input.length() == 0) {
           set.add(output);
           return;
       }

       for(int i=0;i<input.length();i++){
           char ch = input.charAt(i);
           printAllSequencesPermutations(input.substring(0,i) + input.substring(i+1), output + ch, set);
       }

    }

    private static void printAllSequences(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        /*
        either include the character or not include
         */
        printAllSequences(input.substring(1), output);
        printAllSequences(input.substring(1), output + input.charAt(0));
    }
}

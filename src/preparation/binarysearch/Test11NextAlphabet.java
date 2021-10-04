package preparation.binarysearch;

import java.util.Arrays;
import java.util.stream.Stream;

/*
no difference than test10ceilofanelementinasortedarray. the only difference is that here the array is alphaber rather than numbers.
The best way is to create an array of numbers with ascii number of alphabet - 'a', find ceil of the number and then again convert
into alphabet
 */
public class Test11NextAlphabet {
    public static void main(String[] args) {
        char letters[] = { 'A', 'r', 'z' };
        char K = 'z';
        char result = nextGreatestAlphabet(letters, K);

        // Function call
        System.out.println(result);
    }

    private static char nextGreatestAlphabet(char[] letters, char k) {
        /*
        one more condition that if we have to find ceil of last character then it would be arr[0]
         */
        if(k>=letters[letters.length-1])
            return letters[0];

        int[] arr = new int[letters.length];
        for(int i=0;i<letters.length;i++){
            arr[i] = letters[i]-'A';
        }

        int ceilIndex = Test10CeilOfAnElementInASortedArray.ceilSearch(arr, 0, arr.length, k-'A');

        if(ceilIndex!=-1){
            int value = arr[ceilIndex];
            return (char)(value+'A');
        }

        return 0;
    }
}

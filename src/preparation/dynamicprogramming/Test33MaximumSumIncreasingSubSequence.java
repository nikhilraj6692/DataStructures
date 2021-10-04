package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
it is a variation of LIS. In LIS, we make use of previous length at jth position to update length at ith position. In this one,
we will make use of sum to do the same
 */
public class Test33MaximumSumIncreasingSubSequence {
    public static void main(String[] args) {
        int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };

        System.out.print("The maximum sum of the increasing subsequence is " +
                MSIS(A));
        System.out.print("\n========================================\n");
        printAllLIS(A);
    }

    private static void printAllLIS(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<arr.length;i++){
            list.add(i, new ArrayList<>());
        }
        list.get(0).add(arr[0]);

        //take lis also so as to find out sum
        int[] lis = new int[arr.length];
        lis[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                //doing check for lis because sum is dependent upon lis array and so is list
                if(arr[j]<arr[i] && lis[i]<lis[j]){
                    list.set(i, new ArrayList<>(list.get(j)));
                    lis[i] = lis[j];
                }
            }
            list.get(i).add(arr[i]);
            lis[i]+= arr[i];

            System.out.println("LIS[" + i + "] — " + list.get(i));
        }
    }

    private static int MSIS(int[] arr) {
        int[] lis = new int[arr.length];
        lis[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                //doing same as printing sequence...as we have already created array for previous elements so putting that
                //index value in lis[i]
                if(arr[j] < arr[i] && lis[i]<lis[j]){
                    lis[i] = lis[j];
                }
            }

            lis[i]+= arr[i];
        }

        return Arrays.stream(lis).max().getAsInt();
    }
}

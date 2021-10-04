package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
in this problem we are going to find maximum length of sub sequence which is in strictly increasing order...we will use recursion
and memotization to solve the problem. we initialize an array of lis with 0 index as 1. now we start iterating from i+1 to n.
while iterating i, we have to check that the previous elements before i is greater than i or not. if it is greater then add 1 to
the lis value at the same index
 */
public class Test30LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.print("The length of the LIS is " + LIS(arr));
        System.out.print("\n========================================\n");
        printAllLIS(arr);
    }

    private static void printAllLIS(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis,1);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n;i++){
            list.add(i, new ArrayList<>());
        }

        list.get(0).add(arr[0]);

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                //same as above but here we will set a new array at the index for which already increasing array has been
                //manipulated
                if(arr[j]< arr[i] && list.get(i).size() < list.get(j).size()){
                    list.set(i, new ArrayList<>(list.get(j)));
                }
            }

            //finally add the element to the list
            list.get(i).add(arr[i]);
            System.out.println("LIS[" + i + "] — " + list.get(i));
        }



        //finding out the maximum size list index
        int max = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (list.get(max).size() < list.get(i).size()) {
                max = i;
            }
        }

        // print max LIS
        System.out.print(list.get(max));

    }

    private static int LIS(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for(int i=1;i<n;i++){
            for(int j=0; j<i; j++){
                //we will check if the previous element is smaller than current element (i). If yes, then we have to update
                //the count at ith position, but it will only be updated if the value of lis at j + 1  is greater than i,
                //because it is just a possible answer
                if(arr[j] < arr[i] && lis[j] + 1 > lis[i] ){
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max =  Math.max(max, lis[i]);
        }
        return max;
    }
}

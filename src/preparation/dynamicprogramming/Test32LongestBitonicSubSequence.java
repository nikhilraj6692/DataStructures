package preparation.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing. Simply we have to add lds and lis of each
index-1 and find out the longest
 */
public class Test32LongestBitonicSubSequence {
    public static void main(String[] args) {
        int[] A = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };

        System.out.print("The length of the longest bitonic subsequence is " +
                calculateLBS(A));

        /*
        similarly print the longest bitonic array
         */
        LBS(A, A.length-1);
    }

    public static void LBS(int[] arr, int n)
    {
        // `I[i]` stores the longest increasing subsequence, ending at `arr[i]`
        List<List<Integer>> I = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            I.add(new ArrayList<>());
        }

        I.get(0).add(arr[0]);

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (I.get(i).size() < I.get(j).size() && arr[i] > arr[j]) {
                    I.set(i, new ArrayList<>(I.get(j)));
                }
            }
            I.get(i).add(arr[i]);
        }

        // `D[i]` stores the longest decreasing subsequence, starting from `A[i]`
        List<List<Integer>> D = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            D.add(new ArrayList<>());
        }
        D.get(n).add(0, arr[n]);

        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = n; j > i; j--)
            {
                if (D.get(i).size() < D.get(j).size() && arr[i] > arr[j]) {
                    D.set(i, new ArrayList<>(D.get(j)));
                }
            }
            D.get(i).add(0, arr[i]);
        }

        // find the peak element index
        int peak = 0;
        for (int i = 1; i <= n; i++)
        {
            if ((I.get(i).size() + D.get(i).size()) >
                    (I.get(peak).size() + D.get(peak).size())) {
                peak = i;
            }
        }

        System.out.print("The longest bitonic subsequence is ");

        // print longest increasing subsequence ending at peak element
        System.out.print(I.get(peak));

        // pop the front element of LDS as it points to the same element as the
        // rear of LIS
        D.get(peak).remove(0);

        // print longest decreasing subsequence starting from the peak element
        System.out.println(D.get(peak));
    }

    private static int calculateLBS(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for(int i=1;i<n;i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && lis[j] + 1 > lis[i] ){
                    lis[i] = lis[j] + 1;
                }

                if(arr[j] > arr[i] && lds[j] + 1 > lds[i]){
                    lds[i] = lds[j] + 1;;
                }
            }
        }

        int lisMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            lisMax =  Math.max(lisMax, lis[i]);
        }

        int ldsMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ldsMax =  Math.max(ldsMax, lis[i]);
        }

        return ldsMax + lisMax - 1;
    }
}

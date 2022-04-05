package preparation.slidingwindow;

public class Test05MaximumSubArrayWithGivenSum
{

    /*
    this is a problem of sliding window problem, in which we have to find max size of sub array
    and condition here is the sum
    instead of window like in previous problems
     */
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int n = arr.length;
        int k = 15;
        System.out.println("Length = " +
            lenOfLongSubarr(arr, n, k));
    }

    /*
    calculate sum for each j. if sum is less than k, then increment j. if equal then fill out the
     max value (here it is size of
    largest subarray with given sum) and increment j. if greater then increment i with decreasing
     value at i till the point
    when sum is greater than k
     */
    private static int lenOfLongSubarr(int[] arr, int n, int k)
    {
        int i = 0, j = 0;
        int sumSoFar = 0;
        int max = Integer.MIN_VALUE;

        while (j < n)
        {
            sumSoFar += arr[j];

            if (sumSoFar < k)
            {
                j++;
            } else if (sumSoFar == k)
            {
                max = Math.max(max, j - i + 1);
                j++;
            } else
            {
                /*
                this is the main condition, if sum is greater than k, then start incrementing i
                and decrease value at i till sumSoFar
                is less than k
                 */
                while (sumSoFar > k)
                {
                    sumSoFar -= arr[i];
                    i++;
                }
                j++;
            }
        }

        return max;
    }
}

package preparation.arrays;

import java.util.Arrays;

/*
Problem Description



Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar
 such that if we sort(in ascending order) that sub-array, then the whole array should get sorted.
If A is already sorted, output -1.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 1000000



Input Format
First and only argument is an array of non-negative integers of size N.



Output Format
Return an array of length two where the first element denotes the starting index(0-based) and the
 second element denotes the ending index(0-based) of the sub-array. If the array is already
 sorted, return an array containing only one element i.e. -1.



Example Input
Input 1:

A = [1, 3, 2, 4, 5]
Input 2:

A = [1, 2, 3, 4, 5]


Example Output
Output 1:

[1, 2]
Output 2:

[-1]


Example Explanation
Explanation 1:

If we sort the sub-array A1, A2, then the whole array A gets sorted.
Explanation 2:

A is already sorted.
 */
public class Test11FindUnsortedArrayMaxLength
{

    public static void main(String[] args)
    {
        int[] arr = subUnsort(new int[]{1, 3, 2, 4, 5});
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = subUnsort2(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /*
    Solution 2: find element from left which is greater than its next element and find element
    from left which is smaller than its
    previous element. This will give us unsorted array. But note that this unsorted array can
    have some elements which is greater
    than an element in left sorted array and smaller than an element in right sorted array. this
    will expand the unsorted array length.
    consider example for this method.
     */
    private static int[] subUnsort2(int[] arr)
    {
        int min = arr.length - 1;
        int max = 0;

        if (arr.length == 1)
        {
            return new int[]{-1};
        }

        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] > arr[i + 1])
            {
                min = i;
                break;
            }
        }

        for (int i = arr.length - 1; i > 0; i--)
        {
            if (arr[i] < arr[i - 1])
            {
                max = i;
                break;
            }
        }

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = min; i <= max; i++)
        {
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }

        for (int i = 0; i < min; i++)
        {
            if (arr[i] > minVal)
            {
                min = i;
                break;
            }
        }

        for (int i = arr.length - 1; i > max; i--)
        {
            if (arr[i] < maxVal)
            {
                max = i;
                break;
            }
        }

        if (min == arr.length - 1 && max == 0)
        {
            return new int[]{-1};
        }

        return new int[]{min, max};
    }

    /*
   Solution 1: Sort the array and compare original array with sorted array. find minimum and
   maximum unsorted index
    */
    public static int[] subUnsort(int[] A)
    {
        int min = A.length - 1;
        int max = 0;

        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++)
        {
            B[i] = A[i];
        }

        if (A.length == 1)
        {
            return new int[]{-1};
        }

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != B[i])
            {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }

        if (min == A.length - 1 && max == 0)
        {
            return new int[]{-1};
        }

        return new int[]{min, max};
    }
}

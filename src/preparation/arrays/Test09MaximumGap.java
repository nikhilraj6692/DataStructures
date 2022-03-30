package preparation.arrays;

/*
Problem Description

Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the maximum value of j - i;



Example Input
Input 1:

 A = [3, 5, 4, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Maximum value occurs for pair (3, 4).
 */
public class Test09MaximumGap
{
    /*
    find max array and then compare original array with max array. Move pointer in max array till pointer in original array is less
    than max array value. If it is greater than move pointer in original array and start comparing from pointer in max array.
    Note: we don't need to iterate max array from beginning because to the right will be always equal ir lesser elements value in max
    array, so elements in original array will always be smaller than current pointer in max array. Can also be solved via binary
    search where have max array. Iterate for each element in original array and check mid of max array is greater than element in
    original array. If yes then move low = mid+1 else high = mid - 1. Keep track of maxDifference Index.
     */
    public static void main(String[] args)
    {
        System.out.print(maxGap(new int[]{3, 5, 4, 2}));

    }

    private static int maxGap(int[] A)
    {
        //find max array
        int n = A.length;
        int[] max = new int[n];
        max[n-1] = A[n-1];
        for(int i = n-2;i>=0;i--){
            max[i] = Math.max(A[i], max[i+1]);
        }

        int i=0, j=0, maxDiff = Integer.MIN_VALUE;

        while(i<n && j<n){
            if(max[j]>=A[i]){
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }else{
                i++;
            }
        }

        return maxDiff;

    }
}

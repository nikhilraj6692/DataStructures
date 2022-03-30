package preparation.arrays;

/*
Problem Description

Given an integer array A of size N.

You need to check that whether there exist a element which is strictly greater than all the elements on left of it and strictly smaller than all the elements on right of it.

If it exists return 1 else return 0.

NOTE:

Do not consider the corner elements i.e A[0] and A[N-1] as the answer.


Problem Constraints
3 <= N <= 105

1 <= A[i] <= 109



Input Format
First and only argument is an integer array A containing N integers.



Output Format
Return 1 if there exist a element that is strictly greater than all the elements on left of it and strictly  smaller than all the elements on right of it else return 0.



Example Input
Input 1:

 A = [5, 1, 4, 3, 6, 8, 10, 7, 9]
Input 2:

 A = [5, 1, 4, 4]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 A[4] = 6 is the element we are looking for.
 All elements on left of A[4] are smaller than it and all elements on right are greater.
Explanation 2:

 No such element exits.
 */
public class Test12FindPerfectPeak
{

    public static void main(String[] args)
    {
        /*
        Solution: Find max to the left and min to the right of an element. If the element is greater than max and smaller than min,
        it is a perfect peak element.
         */
        System.out.println(perfectPeak(
            new int[]{9488, 25784, 5652, 9861, 31311, 8611, 1671, 7129, 28183, 2743, 11059, 4473, 7927, 21287, 2259, 7214, 32529}));
    }

    public static int perfectPeak(int[] A) {

        if(A.length == 1)
            return 1;

        int[] max = new int[A.length];
        int[] min = new int[A.length];

        max[0] = Integer.MIN_VALUE;

        for(int i=1;i<A.length;i++){
            max[i] = Math.max(max[i-1], A[i-1] );
        }

        min[A.length-1] = Integer.MAX_VALUE;

        for(int i=A.length-2;i>=0;i--){
            min[i] = Math.min(min[i+1], A[i+1]);
        }

        for(int i=1;i<A.length-1;i++){
            if(A[i]>max[i] && A[i]<min[i]){
                return 1;
            }
        }

        return 0;
    }

}

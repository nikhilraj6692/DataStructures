package preparation.arrays;

import java.util.Arrays;

public class Test17NobleInteger
{

    public static void main(String[] args)
    {
        System.out.println(solve(new int[]{-6, -1, 4}));
    }

    public static int solve(int[] A)
    {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 1; i++)
        {
            //check for count till while adjacent elements are equal. That needs to be subtracted
            int temp = i;
            int same = 0;
            while (temp + 1 < A.length && A[temp + 1] == A[temp])
            {
                same++;
                temp++;
            }

            if (Math.abs(A[i]) == A.length - i - 1 - same)
            {
                return 1;

            }

        }
        return -1;
    }
}

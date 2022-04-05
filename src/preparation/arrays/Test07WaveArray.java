package preparation.arrays;

import java.util.Arrays;

/*
print array in such a way that a1>=a2<=a3>=a4....
 */
public class Test07WaveArray
{

    public static void main(String[] args)
    {
        int[] result = wave(new int[]{1, 2, 6, 7, 9, 12});
        for (int num : result)
        {
            System.out.print(num + " ");
        }
    }

    public static int[] wave(int[] A)
    {
        if (A.length == 1)
        {
            return A;
        }

        Arrays.sort(A);

        //swap first and second each time
        for (int i = 0; i < A.length; i = i + 2)
        {
            //swap i and i+1
            int temp = A[i];
            A[i] = A[i + 1];
            A[i + 1] = temp;
        }
        return A;
    }
}

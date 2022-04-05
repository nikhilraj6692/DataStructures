package preparation.arrays;

import java.util.Arrays;

public class Test02PlusOneWithOutputNotHavingZeroAtTheStart
{

    public static void main(String[] args)
    {
        int[] input = new int[]{0, 3, 7, 6, 4, 0, 5, 5, 5};
        int[] output = plusOne(input);
        for (int o : output)
        {
            System.out.print(o + " ");
        }
    }

    public static int[] plusOne(int[] A)
    {
        int length = A.length;
        int[] output = new int[length + 1];

        int carry = 0;

        for (int j = length - 1; j >= 0; j--)
        {
            int sum = 0;
            if (j == length - 1)
            {
                sum = A[j] + 1;
            } else
            {
                sum = A[j] + carry;
            }

            if (sum > 9)
            {
                output[j + 1] = sum % 10;
                carry = sum / 10;
            } else
            {
                output[j + 1] = sum;
                carry = 0;
            }

        }

        if (carry != 0)
        {
            output[0] = 1;
        }

        int i;
        for (i = 0; i < output.length; i++)
        {
            if (output[i] != 0)
            {
                break;
            }
        }

        return Arrays.copyOfRange(output, i, output.length);
    }
}    
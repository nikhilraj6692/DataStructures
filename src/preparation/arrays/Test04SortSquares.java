package preparation.arrays;

public class Test04SortSquares
{

    public static void main(String[] args)
    {
        int[] arr = new int[]{-855, -847, -747, -708, -701, -667, -666, -618, -609, -536, -533,
            -509, -500, -396, -336, -297, -284, -229, -173, -173, -132, -38, -5, 35, 141, 169, 281,
            322, 358, 421, 436, 447, 478, 538, 547, 644, 667, 673, 705, 711, 718, 724, 726, 811,
            869, 894, 895, 902, 912, 942, 961};
        int[] squares = solve(arr);
        for (int val : squares)
        {
            System.out.print(val + "  ");
        }
    }

    public static int[] solve(int[] A)
    {
        //first find pivot where we can find negative and positive number
        int index = -1;

        for (int i = 0; i < A.length; i++)
        {
            if (A[i] >= 0)
            {
                index = i;
                break;
            }
        }

        int[] square = new int[A.length];
        int squareIndex;

        //meaning that there is no positive number
        if (index == -1)
        {
            squareIndex = A.length - 1;
            for (int i = 0; i < A.length; i++)
            {
                square[squareIndex--] = A[i] * A[i];
            }
        }
        //meaning that there is no negative number
        else if (index == 0)
        {
            squareIndex = 0;
            for (int i = 0; i < A.length; i++)
            {
                square[squareIndex++] = A[i] * A[i];
            }
        }
        //mixture of postive and negative numbers
        else
        {
            squareIndex = 0;
            //now do i and j with this pivot
            int i = index - 1;
            int j = index;

            while (i >= 0 && j < A.length)
            {
                if (A[i] * A[i] < A[j] * A[j])
                {
                    square[squareIndex++] = A[i] * A[i];
                    i--;
                } else
                {
                    square[squareIndex++] = A[j] * A[j];
                    j++;
                }
            }

            while (i >= 0)
            {
                square[squareIndex++] = A[i] * A[i];
                i--;
            }
            while (j < A.length)
            {
                square[squareIndex++] = A[j] * A[j];
                j++;
            }
        }
        return square;

    }
}

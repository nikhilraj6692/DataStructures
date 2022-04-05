package preparation.binarysearch;

/*
it is a very interesting problem. we have to find the element in the matrix such that all columns
 and all rows are sorted.
Approach : start from last element, arr[0][n-1]. If it is equal to the key, return index, but if
key values is less than the elem
atthat index, do a j-- as it is not possible to have the element in that column. However if the
key is greater than th eindex, we
will have to move column wise and do i++. Repeat this until i and j are in bounds
 */
public class Test18FindElementInMatrix
{

    public static void main(String[] args)
    {
        int mat[][] =
            {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
            };

        search(mat, 4, 29);
    }

    private static void search(int[][] mat, int n, int key)
    {
        int i = 0;
        int j = n - 1;

        while (i >= 0 && i < n && j >= 0 && j < n)
        {
            if (mat[i][j] == key)
            {
                System.out.print(i + " " + j);
                return;
            } else if (key < mat[i][j])
            {
                j--;
            } else if (key > mat[i][j])
            {
                i++;
            }
        }

        System.out.print(-1);
    }
}

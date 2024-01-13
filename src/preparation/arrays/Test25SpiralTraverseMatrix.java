package preparation.arrays;

//fill matrix in spiral form
public class Test25SpiralTraverseMatrix
{

    public static void main(String[] args)
    {
        int n = 4;
        int[][] mat = new int[n][n];
        int top=0, left=0, bottom=n-1, right=n-1;
        int count=0;

        while(left<=right && top<=bottom)
        {
            for (int i = left; i <= right; i++)
            {
                mat[top][i] = ++count;
            }
            top++;

            printMatrix(mat, n);

            for (int i = top; i <= bottom; i++)
            {
                mat[i][right] = ++count;
            }
            right--;

            printMatrix(mat, n);

            for (int i = right; i >= left; i--)
            {
                mat[bottom][i] = ++count;
            }

            bottom--;

            printMatrix(mat, n);

            for (int i = bottom; i >= top; i--)
            {
                mat[i][left] = ++count;
            }

            left++;

            printMatrix(mat, n);
        }

    }

    private static void printMatrix(int[][] mat, int n)
    {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

package preparation.stack;

public class Test09MaxAreaOfBinaryMatrix
{

    public static void main(String[] args)
    {
        int R = 4;
        int C = 4;

        int A[][] = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
        };

        /*
        this problem is similar to Test08FindMaxHistogramArea. In prev problem there was only one
         array and we had to find
        maximum area. This problem can be splitted into the same problem by using R number of
        rows. For each row, we can create
        a similar array like for row 0, it will be 0 1 1 0 and area would be 2. For row 1 it
        would be 1+0 1+1 1+1 0+1, i.e. 1 2 2 1
        for row 3, it would be 1+1 1+2 1+2 1+2,i.e. 2 3 3 3, row 4 would be 2+1 3+1 0(since it is
         0) 0,i.e. 3 4 0 0. Then find
        max of all rows area
         */
        System.out.print("\nArea of maximum rectangle is "
            + maxRectangle(R, C, A));
    }

    private static int maxRectangle(int r, int c, int[][] a)
    {
        int[] arr = new int[c];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (a[i][j] != 0)
                {
                    arr[j] = a[i][j] + arr[j];
                } else
                {
                    arr[j] = 0;
                }
            }

            //find max area
            int area = Test08FindMaxHistogramArea.getMaxArea(arr, c);
            System.out.println("\nArea is " + area);
            max = Math.max(max, area);
        }

        return max;
    }
}

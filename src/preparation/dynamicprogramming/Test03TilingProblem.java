package preparation.dynamicprogramming;

public class Test03TilingProblem
{

    public static void main(String[] args)
    {
        /*
        If you have 2*m tiles board and you have to fill it by 2*1 tiles, then there are two ways
         to fill. think that if you fill the
        board with tiles vertically, then for each tile filled vertically remaining would be
        count(n-1) and if board is filled with
        tiles horizontally, then for each tile filled horizontally remaining would be count(n-2).
         For the base condition think like
        if there were 2*1 tiles, then for vertical n would be 1 and should return 1.
         */

        //non recursive...it uses array to save already made calls
        int n = 4;
        int tile[] = new int[n + 1];
        // base case
        tile[0] = 0;
        tile[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            tile[i] = tile[i - 1] + tile[i - 2]; // use recursive formula
        }
        System.out.println(tile[n]);

        //recursive way
        System.out.println(countNoOfWays(4));

        //tiling problem for n*m board and 1*m tile
        System.out.print(countNoOfWays(7, 4));
    }

    private static int countNoOfWays(int n, int m)
    {
        int[] count = new int[n + 1];
        count[0] = 1;

        for (int i = 1; i <= n; i++)
        {
            if (i > m)
            {
                count[i] = count[i - 1] + count[i - m];
            } else if (i < m || i == 1)
            {
                count[i] = 1;
            } else
            {
                count[i] = 2;
            }

        }

        return count[n];
    }

    private static int countNoOfWays(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        if (n == 1 || n == 2)
        {
            return n;
        }

        return countNoOfWays(n - 1) + countNoOfWays(n - 2);

    }
}

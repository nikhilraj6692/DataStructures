package preparation.dynamicprogramming;

/*
In the problem, we have two travellers, one travels from top left and another travels from top right. Both of them
have to pick up maximum coins in such a way that they can travel (i+1,j+1),(i+1,j) or (i+1,j-1). One more condition
is that if both travellers are traversing same cell, then only one of them can pick coin in the same cell.
 */
public class Test34FindMaximumCoinsInAMatrix {
    public static void main(String[] args) {
        int[][] mat =
                {
                        {0, 2, 4, 1},
                        {4, 8, 3, 7},
                        {2, 3, 6, 2},
                        {9, 7, 8, 3},
                        {1, 5, 9, 4}
                };

        System.out.println("The maximum coins collected is " + getMaxCoins(mat));
    }

    private static int getMaxCoins(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean visited[][] = new boolean[row][col];

        int i = 0, j = 0;
        int sum = mat[i][j];
        visited[i][j] = true;

        while (i < row && j < col) {
            int first = isValid(i + 1, j + 1, row, col,visited) ? (mat[i + 1][j + 1]) : 0;
            int second = isValid(i + 1, j - 1, row, col,visited) ? (mat[i + 1][j - 1]) : 0;
            int third = isValid(i + 1, j, row, col,visited) ? (mat[i + 1][j]) : 0;

            int max = Math.max(first, Math.max(second, third));

            if (max != 0) {
                sum = sum + max;
                System.out.print(max+ " ");
                if (max == first) {
                    i = i + 1;
                    j = j + 1;
                } else if (max == second) {
                    i = i + 1;
                    j = j - 1;
                } else {
                    i = i + 1;
                }

                visited[i][j] = true;
            }else{
                break;
            }
        }

        System.out.println();

        //do for second traveller
        i = 0;
        j = col-1;
        sum+= mat[i][j];
        visited[i][j] = true;

        while (i < row && j < col) {
            int first = isValid(i + 1, j + 1, row, col,visited) ? (mat[i + 1][j + 1]) : 0;
            int second = isValid(i + 1, j - 1, row, col,visited) ? (mat[i + 1][j - 1]) : 0;
            int third = isValid(i + 1, j, row, col,visited) ? (mat[i + 1][j]) : 0;

            int max = Math.max(first, Math.max(second, third));

            if (max != 0) {
                sum = sum + max;
                System.out.print(max+ " ");
                if (max == first) {
                    i = i + 1;
                    j = j + 1;
                } else if (max == second) {
                    i = i + 1;
                    j = j - 1;
                } else {
                    i = i + 1;
                }

                visited[i][j] = true;
            }else{
                break;
            }
        }
        return sum;
    }

    private static boolean isValid(int r, int c, int row, int col, boolean[][] visited) {
        return r >= 0 && r < row && c >= 0 && c < col && !visited[r][c];
    }
}
